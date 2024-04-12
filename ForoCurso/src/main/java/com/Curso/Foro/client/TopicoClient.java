package com.Curso.Foro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Curso.Foro.controller.TopicoDTO;

import jakarta.ws.rs.Path;

@FeignClient (name = "mcsv-ForoTopico", url= "localhost:8093/api/topico")
public interface TopicoClient {

	@GetMapping ("/curso{idCurso}")
	List<TopicoDTO> findAllTopicoByCursoId (@PathVariable Long idCurso);
}
