package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Productodescuento;
@Repository
public class ProductosDescuentoDao implements ProductosDescuentoDaoI{
	@Autowired
	ProductosDescuentoJPA productosDescJPA;

	@Override
	public Productodescuento addProductoDescuento(Productodescuento productodescuento) {
		// TODO Auto-generated method stub
		return productosDescJPA.save(productodescuento);
	}

	@Override
	public List<Productodescuento> getAllProductos() {
		// TODO Auto-generated method stub
		return productosDescJPA.findAll();
	}
 
	@Override
	public List<Productodescuento> getAllProductosxPromo(int idDescuento) {
		// TODO Auto-generated method stub
		return productosDescJPA.findByFK_descuento(idDescuento);
	}

	@Override
	public Productodescuento getProductoDescuento(int idProducto) {
		// TODO Auto-generated method stub
		return productosDescJPA.findById(idProducto).orElse(null);
	}

	@Override
	public Productodescuento updateProductodescuento(Productodescuento productodescuento) {
		// TODO Auto-generated method stub
		return productosDescJPA.save(productodescuento);
	}

	@Override
	public boolean deleteProductodescuento(int idProductodescuento) {
		// TODO Auto-generated method stub
		 productosDescJPA.deleteById(idProductodescuento);
		 return true;
	}

	@Override
	public Productodescuento validarProductoDescuento(int idProducto, int idPromo) {
		// TODO Auto-generated method stub
		return productosDescJPA.findProducDescuento(idPromo, idProducto);
	}
	

}
