package com.Respuesta.Foro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Respuesta.For.client.TopicoClient;
import com.Respuesta.Foro.controller.TopicoDTO;
import com.Respuesta.Foro.entity.Respuesta;
import com.Respuesta.Foro.entity.datosRespuesta;
import com.Respuesta.Foro.http.response.TopicoByRespuesta;
import com.Respuesta.Foro.repository.RespuestaRepository;

@Service
public class RespuestaImp implements RespuestaService {

	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@Autowired
	private TopicoClient topicoCl;
	
	@Override
	public List<Respuesta> findAll() {
		return respuestaRepository.findAll();
	}

	@Override
	public Respuesta findById(Long id) {
		return respuestaRepository.findById(id).orElseThrow();
	}

	@Override
	public void save(datosRespuesta respuesta) {
		respuestaRepository.save(respuesta);		
	}

	@Override
	public TopicoByRespuesta findTopicosByIdRespuesta(Long idRespuesta) {
		// para obtener la respuesta
		Respuesta respuesta = respuestaRepository.findById(idRespuesta).orElse(new Respuesta());
		//para obtener el topico
		List<TopicoDTO> topicoDTO = topicoCl.findAllTopicosByRespuesta(idRespuesta);
		
		return TopicoByRespuesta.builder()
				.autor(respuesta.getAutorId())
				.mensaje(respuesta.getMensaje())
				.topico(topicoDTO)
				.build();
	}

}
