package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.model.Descuento;
@Repository
public class DescuentoDao implements DescuentosDaoI {
	@Autowired
	DescuentoJPA descuentoJPA;

	@Override
	public Descuento addDescuento(Descuento descuento) {
		// TODO Auto-generated method stub
		return descuentoJPA.save(descuento);
	}

	@Override
	public List<Descuento> getAllDescuentos() {
		// TODO Auto-generated method stub
		return descuentoJPA.findAll();
	}

	@Override
	public Descuento getDescuento(int id) {
		// TODO Auto-generated method stub
		return descuentoJPA.findById(id).orElse(null);
	}

	@Override
	public Descuento updateDescuento(Descuento descuento) {
		// TODO Auto-generated method stub
		return descuentoJPA.save(descuento);
	}

	@Override
	public void deleteDescuetn(int id) {
		descuentoJPA.deleteById(id);
	}

	@Override
	public boolean validarCodigo(String cod) {
		return descuentoJPA.validarCod(cod);
	}

	@Override
	public Descuento validarCodigoDescuento(String cod) {
		return descuentoJPA.validarCodDesc(cod);
	}


}
