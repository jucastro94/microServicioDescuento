package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ProductosDescuentoDaoI;
import co.edu.ue.model.Log;
import co.edu.ue.model.Productodescuento;
@Service
public class ProductoDescuentoService implements ProductoDescuentoServiceI {
	@Autowired
	ProductosDescuentoDaoI productosDescDao;

	@Override
	public Productodescuento addProductoDescuento(Productodescuento productodescuento, int usu) {
		registarLog(usu,"insert","agrega producto: "+productodescuento.getFK_producto()+" a descuento: "+ productodescuento.getFK_descuento());
		return productosDescDao.addProductoDescuento(productodescuento);
	}

	@Override
	public List<Productodescuento> getAllProductos() {
		// TODO Auto-generated method stub
		return productosDescDao.getAllProductos();
	}

	@Override
	public List<Productodescuento> getAllProductosxPromo(int idpromo) {
		// TODO Auto-generated method stub
		return productosDescDao.getAllProductosxPromo(idpromo);
	}

	@Override
	public Productodescuento getProductoDescuento(int idProducto) {
		// TODO Auto-generated method stub
		return productosDescDao.getProductoDescuento(idProducto);
	}

	@Override
	public Productodescuento updateProductodescuento(Productodescuento productodescuento, int usu) {
		registarLog(usu,"udate","modifica Producto: "+productodescuento.getFK_producto()+" en descuento: "+ productodescuento.getFK_descuento());
		return productosDescDao.updateProductodescuento(productodescuento);
	}

	@Override
	public boolean deleteProductodescuento(int idProductodescuento, int usu) {
		registarLog(usu,"elimina","elimina descauento a Producto: "+idProductodescuento);
		return productosDescDao.deleteProductodescuento(idProductodescuento);
	}
	private void registarLog(int usu, String accion, String observacion) {
		Log lg = new Log();
		lg.setAccion(accion);
		lg.setIdUsuario(usu);
		lg.setFecha(lg.obtenerFecha());
		lg.setObservacion(observacion);
	}

	@Override
	public boolean validarProductoDescuento(int idProducto, int idPromo) {
		if(productosDescDao.validarProductoDescuento(idProducto, idPromo)!=null) {
			return true;
		}
		return false;
	}
	
}
