package com.Topico.Foro.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Topico.Foro.Controller.RespuestaDTO;

@FeignClient (name = "mcsv-ForoRespuesta", url = "localhost:8092/api/respuesta")
public interface RespuestaClient {

	@GetMapping ("/topico{idTopico}")
	List<RespuestaDTO> findAllRespuestaByTopico (@PathVariable Long idTopico);
}
