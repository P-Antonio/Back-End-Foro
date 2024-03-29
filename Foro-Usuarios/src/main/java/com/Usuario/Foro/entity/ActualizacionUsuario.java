package com.Usuario.Foro.entity;

import jakarta.validation.constraints.NotNull;

public record ActualizacionUsuario( @NotNull Long Id, String Username, String email) {

}
