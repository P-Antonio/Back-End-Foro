package com.Respuesta.Foro.service;

import java.util.List;

import com.Respuesta.Foro.entity.Respuesta;
import com.Respuesta.Foro.entity.datosRespuesta;
import com.Respuesta.Foro.http.response.TopicoByRespuesta;

public interface RespuestaService {

	List<Respuesta> findAll();
	Respuesta findById(Long id);
	void save(datosRespuesta respuesta);
	TopicoByRespuesta findTopicosByIdRespuesta(Long idRespuesta); 
	
}
