package com.Usuario.Foro.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroUsuario(
		@NotBlank
		String username,
		@Email
		@NotBlank
		String email,
		@NotBlank
		String contrasena) {

}
