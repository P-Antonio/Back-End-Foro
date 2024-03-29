package com.Topico.Foro.entity;

import java.time.LocalDateTime;

public record listadoTopico (Long id, String Titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico status, Long cursoId, Long respuestaId, Boolean existe) {

	public listadoTopico(Topico topico) {
		this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), 
				topico.getStatus(), topico.getCursoId(), topico.getRespuestasId(), topico.getExiste());
	}
}
