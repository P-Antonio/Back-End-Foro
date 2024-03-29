package com.Usuario.Foro.entity;


public record DatosListadoUsuario(Long Id, String Username, String email) {

	public DatosListadoUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getUsername(), usuario.getEmail());
	}
}
