package com.Respuesta.For.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Respuesta.Foro.controller.TopicoDTO;

@FeignClient (name = "mcsv-ForoTopico", url = "localhost:8093/api/topico")
public interface TopicoClient {
	
	@GetMapping("/respuesta{idRespuesta}")
	List<TopicoDTO> findAllTopicosByRespuesta (@PathVariable Long idRespuesta);
}
