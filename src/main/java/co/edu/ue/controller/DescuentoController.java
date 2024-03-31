package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.model.Descuento;
import co.edu.ue.service.DescuentoServiceI;

@RestController
public class DescuentoController {
	@Autowired
	DescuentoServiceI descuentoServ;

	@GetMapping(value="descuentos", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Descuento>> getDescuentos(){
		HttpHeaders headers = new HttpHeaders();
		List<Descuento> dato= descuentoServ.getAllDescuentos();
		return new ResponseEntity<List<Descuento>>(dato,headers,HttpStatus.OK);
	}
	@GetMapping(value="descuento/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Descuento> getDescuentos(@PathVariable("id") int id ){
		HttpHeaders headers = new HttpHeaders();
		Descuento dato= descuentoServ.getDescuento(id);
		return new ResponseEntity<Descuento>(dato,headers,HttpStatus.OK);
	}
	
	@PostMapping(value="addDescuento/{idUsu}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Descuento> addDescuento(@RequestBody Descuento descuento,@PathVariable("idUsu") int idUsu) {
		HttpHeaders headers = new HttpHeaders();
		if(descuentoServ.validarCodigoDescuento(descuento.getCodDescuento())!= null) {
			Descuento dato= descuentoServ.addDescuento(descuento,idUsu);
			return new ResponseEntity<Descuento>(dato,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Descuento>(null,headers,HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping(value="updateDescuento/{idUsu}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Descuento> updateDescuento(@RequestBody Descuento descuento,@PathVariable("idUsu") int idUsu) {
		HttpHeaders headers = new HttpHeaders();
		if(descuentoServ.validarCodigoDescuento(descuento.getCodDescuento())!= null) {
			Descuento dato= descuentoServ.updateDescuento(descuento,idUsu);
			return new ResponseEntity<Descuento>(dato,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Descuento>(null,headers,HttpStatus.NOT_FOUND);
		}
		
	}
	@DeleteMapping(value="deleteDescuento/{idDescuento}/{idUsu}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteDescuento(@PathVariable("idDescuento") int id, @PathVariable("idUsu") int idUsu) {
		HttpHeaders headers = new HttpHeaders();
		if(descuentoServ.getDescuento(id)!= null) {
			boolean dato= descuentoServ.deleteDescuetn(id,idUsu);
			return new ResponseEntity<Boolean>(dato,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(null,headers,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="valDescuento/{codDescuento}", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validarDescuento(@PathVariable("codDescuento") String cod){
		HttpHeaders headers = new HttpHeaders();
		boolean dato= descuentoServ.validarCodigo(cod);
		//System.out.println("-----------------"+dato);
		if(dato) {
			return new ResponseEntity<Boolean>(true,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(false,headers,HttpStatus.NOT_FOUND);
		}
		
	}
	
}
