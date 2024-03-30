package com.Respuesta.Foro.entity;

import java.net.URI;
import java.time.LocalDateTime;

public record listadoRespuesta(Long id, String mensaje, Long topicoId, LocalDateTime fechaCreacion, Long autorId, Boolean solucion) {

	public listadoRespuesta(Respuesta respuesta) {
		this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopicoId(), respuesta.getFechaCreacion(),
				respuesta.getAutorId(), respuesta.getSolucion());
	}
}
