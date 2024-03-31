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

import co.edu.ue.model.Productodescuento;
import co.edu.ue.service.ProductoDescuentoServiceI;

@RestController
public class ProductoDescuentoController {
	@Autowired
	ProductoDescuentoServiceI producDescServiceI;
	
	@PostMapping(value="addProductoDescuento/{idUsu}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productodescuento> addDescuento(@RequestBody Productodescuento productDesc,@PathVariable("idUsu") int idUsu) {
		HttpHeaders headers = new HttpHeaders();
		if(producDescServiceI.validarProductoDescuento(productDesc.getFK_producto(),productDesc.getFK_descuento())) {
			Productodescuento dato=producDescServiceI.addProductoDescuento(productDesc,idUsu);
			return new ResponseEntity<Productodescuento>(dato,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Productodescuento>(null,headers,HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="getAllProductos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Productodescuento>> getAllProductos() {
		HttpHeaders headers = new HttpHeaders();
		List<Productodescuento> dato= producDescServiceI.getAllProductos();
		return new ResponseEntity<List<Productodescuento>>(dato,headers,HttpStatus.OK);
	}
	@GetMapping(value="getAllProductosxPromo/{idpromo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Productodescuento>> getAllProductosxPromo(@PathVariable("idpromo") int idpromo) {
		HttpHeaders headers = new HttpHeaders();
		List<Productodescuento> dato= producDescServiceI.getAllProductosxPromo(idpromo);
		return new ResponseEntity<List<Productodescuento>>(dato,headers,HttpStatus.OK);
	}
	@GetMapping(value="getAllProductosxPromo/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productodescuento> getProductoDescuento(@PathVariable("idProducto") int idProducto) {
		HttpHeaders headers = new HttpHeaders();
		Productodescuento dato= producDescServiceI.getProductoDescuento(idProducto);
		return new ResponseEntity<Productodescuento>(dato,headers,HttpStatus.OK);
	}
	@PutMapping(value="updateProductodescuento/{idUsu}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Productodescuento> updateProductodescuento(@RequestBody Productodescuento productDesc,@PathVariable("idUsu") int idUsu) {
		HttpHeaders headers = new HttpHeaders();
		if(producDescServiceI.validarProductoDescuento(productDesc.getFK_producto(),productDesc.getFK_descuento())) {
			Productodescuento dato=producDescServiceI.updateProductodescuento(productDesc,idUsu);
			return new ResponseEntity<Productodescuento>(dato,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Productodescuento>(null,headers,HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(value="deleteProductodescuento/{idProductoDescuento}/{idUsu}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteProductodescuento(@PathVariable("idProductoDescuento") int idProductoDescuento,@PathVariable("idUsu") int idUsu) {
		HttpHeaders headers = new HttpHeaders();
		if(producDescServiceI.deleteProductodescuento(idProductoDescuento,idUsu)) {
			return new ResponseEntity<Boolean>(true,headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(false,headers,HttpStatus.NOT_FOUND);
		}
	}
}
