package com.Curso.Foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Curso.Foro.client.TopicoClient;
import com.Curso.Foro.entity.ActualizarCurso;
import com.Curso.Foro.entity.Curso;
import com.Curso.Foro.entity.DatosCurso;
import com.Curso.Foro.entity.ListadoCurso;
import com.Curso.Foro.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {

	 @Autowired
	 private CursoRepository cursoRepository;
	 
	 @Autowired
	 private TopicoClient topicoClient;
	 
	 @PostMapping
	 @Transactional
	 public ResponseEntity<?> creatCurso (@RequestBody @Valid DatosCurso curso, UriComponentsBuilder builder){
		 var guardarCurso = new Curso(curso);
		 cursoRepository.save(guardarCurso);
		 
		 var uri= builder.path("/curso{id}").buildAndExpand(guardarCurso.getId()).toUri();
		 return ResponseEntity.created(uri).body(new ListadoCurso(guardarCurso));
	 }
	 
	 @PutMapping
	 @Transactional
	 public ResponseEntity<?> actualizarCurso(@RequestBody @Valid ActualizarCurso curso){
		 var putCurso = cursoRepository.getReferenceById(curso.id());
		 putCurso.ActualizarCurso(curso);
		 return ResponseEntity.ok(new ListadoCurso(putCurso));
	 }
	 
	 @GetMapping
	 public ResponseEntity<?> obtenercurso(@PageableDefault (size = 5, sort ={"nombre"}) Pageable pagination){
		 var listado = cursoRepository.findAllByNombreIsTrue(pagination).map(ListadoCurso :: new);
		 return ResponseEntity.ok(listado);
	 }
	 
	 @GetMapping ("/topico{cursoId}")
	 private ResponseEntity<?> cursoByIdTopico (@PathVariable Long idTopico){
		 var topico = cursoRepository.findByTopicosId(idTopico);
		 return ResponseEntity.ok(topico);
	 }
	 
	 @GetMapping ("/findTopico(cursoId)")
	 public ResponseEntity<?> obtenerTopicoByCursoId(@PathVariable Long cursoId){
		 return ResponseEntity.ok(topicoClient.findAllTopicoByCursoId(cursoId));
	 }
}
