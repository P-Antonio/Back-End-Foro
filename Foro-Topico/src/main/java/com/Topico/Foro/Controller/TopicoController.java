package com.Topico.Foro.Controller;

import org.hibernate.mapping.List;
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

import com.Topico.Foro.Repository.TopicosRepository;
import com.Topico.Foro.Service.TopicoService;
import com.Topico.Foro.entity.Topico;
import com.Topico.Foro.entity.actualizarTopico;
import com.Topico.Foro.entity.datosTopico;
import com.Topico.Foro.entity.listadoTopico;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/api/topico")
public class TopicoController {

	@Autowired
	private TopicosRepository topicosRepository;
	
	@Autowired
	private TopicoService topicoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<listadoTopico> crearTopico(@RequestBody @Valid datosTopico datos, UriComponentsBuilder uri) {
		var topico = new Topico(datos);
		topicosRepository.save(topico);
		
		var uriP = uri.path("/topico{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uriP).body(new listadoTopico(topico));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> actualizarTopico (@RequestBody @Valid actualizarTopico actualizacion){
		var topico = topicosRepository.getReferenceById(actualizacion.id());
		topico.putTopico(actualizacion);
		return ResponseEntity.ok(new listadoTopico(topico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTopicoById (@PathVariable Long id){
		var topico = topicosRepository.getReferenceById(id);
		
		return ResponseEntity.ok(new listadoTopico(topico));
	}
	@GetMapping
	public ResponseEntity<?> obtenerTopico (@PageableDefault(size = 5, sort = {"titulo"}) Pageable paginacion){
		var page= topicosRepository.findAllByExisteIsTrue(paginacion).map(listadoTopico :: new);
		return ResponseEntity.ok(page);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> eliminarTopico(@PathVariable Long id){
		var topico = topicosRepository.getReferenceById(id);
		topico.eliminar();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/respuesta{idRespuesta}")
	public ResponseEntity<?> obtenerRespuestaById (@PathVariable Long idRespuesta){
		var respuesta = topicosRepository.findByRespuestasId(idRespuesta);
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping ("/findRespuesta{idTopico}")
	public ResponseEntity<?> obtenerRespuestaByTopico (@PathVariable Long idTopico){
		return ResponseEntity.ok(topicoService.findRespuestaByIdTopico(idTopico));
	}
	
	@GetMapping ("curso{idCurso}")
	public ResponseEntity<?> obtenerCursoById (@PathVariable Long idCurso){
		var curso = topicosRepository.findByCursoId(idCurso);
		return ResponseEntity.ok(curso);
	}
	
}
