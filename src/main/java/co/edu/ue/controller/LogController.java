package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.ue.model.Log;
import co.edu.ue.service.LogServiceI;

public class LogController {
	@Autowired
	LogServiceI logService;
	
	@GetMapping(value="log/{id}", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Log> getLog(@PathVariable("id") int id) {
		Log dato= logService.getLog(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Log>(dato,headers,HttpStatus.OK);
	}
	
	@GetMapping(value="logs", produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Log>>getProductos(){
		List<Log>dato= logService.getAllLog();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Log>>(dato,headers,HttpStatus.OK);
	}
	
	@PostMapping(value="addLog", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Log> addlog(@RequestBody Log log) {
		Log dato=  logService.addLog(log);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Log>(dato,headers,HttpStatus.OK);
	}
}
