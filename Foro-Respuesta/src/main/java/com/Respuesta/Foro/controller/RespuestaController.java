package com.Respuesta.Foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Respuesta.Foro.entity.Respuesta;
import com.Respuesta.Foro.entity.actRespuesta;
import com.Respuesta.Foro.entity.datosRespuesta;
import com.Respuesta.Foro.entity.listadoRespuesta;
import com.Respuesta.Foro.repository.RespuestaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("respuesta")
public class RespuestaController {

	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> responder (@RequestBody @Valid datosRespuesta datos, UriComponentsBuilder builder){
		var respuesta = new Respuesta(datos);
		respuestaRepository.save(respuesta);
		
		var uri = builder.path("/repuesta{id}").buildAndExpand(respuesta.getId()).toUri();
		return ResponseEntity.created(uri).body(new listadoRespuesta(respuesta));
	}
	
	@PutMapping ("/{id}")
	@Transactional
	public ResponseEntity<?> actualizarRespuesta (@RequestBody @Valid actRespuesta respuesta){
		var actualizacion = respuestaRepository.getReferenceById(respuesta.id());
		actualizacion.putRespuesta(respuesta);
		return ResponseEntity.ok(new listadoRespuesta(actualizacion));
	}
}
