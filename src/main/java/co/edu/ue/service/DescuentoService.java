package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.DescuentosDaoI;
import co.edu.ue.model.Descuento;
import co.edu.ue.model.Log;
@Service
public class DescuentoService implements DescuentoServiceI{
	@Autowired
	DescuentosDaoI descuentoDao;
	
	@Override
	public Descuento addDescuento(Descuento descuento, int usu) {
		registarLog(usu,"insert","agrega descuento: "+ descuento.getCodDescuento());
		return descuentoDao.addDescuento(descuento);
	}
	
	@Override
	public List<Descuento> getAllDescuentos() {
		return descuentoDao.getAllDescuentos();
	}
	
	@Override
	public Descuento getDescuento(int id) {
		return descuentoDao.getDescuento(id);
	}
	
	@Override
	public Descuento updateDescuento(Descuento descuento, int usu) {
		registarLog(usu,"update","modifica descuento: "+ descuento.getIddescuento());
		return descuentoDao.updateDescuento(descuento);
	}
	
	@Override
	public boolean deleteDescuetn(int id, int usu) {
		descuentoDao.deleteDescuetn(id);
		registarLog(usu,"delete","elimina descuento: "+ id);
		return true;
	}
	@Override
	public boolean validarCodigo(String cod) {
		return descuentoDao.validarCodigo(cod);
	}
	@Override
	public Descuento validarCodigoDescuento(String cod) {
		return descuentoDao.validarCodigoDescuento(cod);
	}
	private void registarLog(int usu, String accion, String observacion) {
		Log lg = new Log();
		lg.setAccion(accion);
		lg.setIdUsuario(usu);
		lg.setFecha(lg.obtenerFecha());
		lg.setObservacion(observacion);
		
	}
}
