package com.Respuesta.Foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.Respuesta.Foro.service.RespuestaService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;

@RestController
@RequestMapping ("api/respuesta")
public class RespuestaController {

	@Autowired
	private RespuestaRepository respuestaRepository;
	@Autowired
	private RespuestaService respuestaService;
	
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
	
	@GetMapping
	public ResponseEntity<?> obtenerRespuesta(@PageableDefault (size =5, sort={"mensaje"}) Pageable pagination){
		var page = respuestaRepository.findAllBySolucionIsTrue(pagination).map(listadoRespuesta :: new);
		return ResponseEntity.ok(page);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> eliminarRespuesta(@PathVariable Long id){
		respuestaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping ("/topico{idTopico}")
	public ResponseEntity<?> respuestaByIdTopico(@PathVariable Long idTopico){
		var topico = respuestaRepository.findByTopicoId(idTopico);
		return ResponseEntity.ok(topico);
	}
	
	@GetMapping("findTopico{idRespuesta}")
	public ResponseEntity<?> obtenerTopicoByRespuesta(@PathVariable Long idRespuesta){
		return ResponseEntity.ok(respuestaService.findTopicosByIdRespuesta(idRespuesta));
	}
}
