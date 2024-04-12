package com.Curso.Foro.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarCurso(
		@NotNull
		Long id, 
		@NotBlank
		String nombre, 
		@NotBlank
		String Categoria) {

}
