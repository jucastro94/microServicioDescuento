package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Descuento;

public interface DescuentoServiceI {
	Descuento addDescuento(Descuento descuento, int usu);
	List<Descuento>getAllDescuentos();
	Descuento getDescuento(int id);
	Descuento updateDescuento (Descuento descuento, int usu);
	boolean deleteDescuetn(int id, int usu);
	boolean validarCodigo(String cod);
	Descuento validarCodigoDescuento(String cod);
}
