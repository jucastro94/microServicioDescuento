package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Productodescuento;

public interface ProductoDescuentoServiceI {
	Productodescuento addProductoDescuento(Productodescuento productodescuento, int usu);
	List<Productodescuento>getAllProductos();
	List<Productodescuento>getAllProductosxPromo(int idpromo);
	Productodescuento getProductoDescuento(int idProducto);
	Productodescuento updateProductodescuento(Productodescuento productodescuento, int usu);
	boolean deleteProductodescuento(int idProductodescuento, int usu);
	boolean validarProductoDescuento(int idProducto, int idPromo);
}
