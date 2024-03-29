package com.Topico.Foro.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record actualizarTopico(
		@NotNull
		Long id, 
		@NotBlank
		String titulo,
		@NotBlank
		String mensaje) {

}
