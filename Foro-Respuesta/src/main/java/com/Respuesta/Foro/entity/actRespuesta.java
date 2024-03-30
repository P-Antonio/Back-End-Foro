package com.Respuesta.Foro.entity;

import jakarta.validation.constraints.NotBlank;

public record actRespuesta(
		@NotBlank
		Long id,
		@NotBlank
		String mensaje
		) {

}