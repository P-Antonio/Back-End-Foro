package com.Topico.Foro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Topico.Foro.Controller.RespuestaDTO;
import com.Topico.Foro.Repository.TopicosRepository;
import com.Topico.Foro.client.RespuestaClient;
import com.Topico.Foro.entity.Topico;
import com.Topico.Foro.http.response.RespuestaByTopico;

@Service
public class TopicoServiceImp implements TopicoService {

	@Autowired
	private TopicosRepository topicoRepository;
	
	@Autowired
	private RespuestaClient respuestaClient;
	
	@Override
	public RespuestaByTopico findRespuestaByIdTopico(Long idTopico) {
		//obtener topico
		Topico topico = topicoRepository.findById(idTopico).orElse(new Topico());
		//obtener respuesta
		List<RespuestaDTO> respuestaDTO = respuestaClient.findAllRespuestaByTopico(idTopico);
		return RespuestaByTopico.builder()
				.titulo(topico.getTitulo())
				.mensaje(topico.getMensaje())
				.respuestaDTO(respuestaDTO)
				.build();
	}

}
