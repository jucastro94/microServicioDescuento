package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Productodescuento;

public interface ProductosDescuentoDaoI {

		Productodescuento addProductoDescuento(Productodescuento productodescuento);
		List<Productodescuento>getAllProductos();
		List<Productodescuento>getAllProductosxPromo(int idpromo);
		Productodescuento getProductoDescuento(int idProducto);
		Productodescuento updateProductodescuento(Productodescuento productodescuento);
		boolean deleteProductodescuento(int idProductodescuento);
		Productodescuento validarProductoDescuento(int idProducto, int idPromo);
}
