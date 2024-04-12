package com.Respuesta.Foro.controller;

import java.time.LocalDateTime;

import com.Topico.Foro.entity.StatusTopico;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicoDTO {

	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	private Long autorId;
	private Long cursoId;
	private Long respuestasId;
	private Boolean existe;
}
