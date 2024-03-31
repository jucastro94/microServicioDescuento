package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.model.Descuento;

public interface DescuentosDaoI {
	Descuento addDescuento(Descuento descuento);
	List<Descuento>getAllDescuentos();
	Descuento getDescuento(int id);
	Descuento updateDescuento (Descuento descuento);
	void deleteDescuetn(int id);
	boolean validarCodigo(String cod);
	Descuento validarCodigoDescuento(String cod);
}
