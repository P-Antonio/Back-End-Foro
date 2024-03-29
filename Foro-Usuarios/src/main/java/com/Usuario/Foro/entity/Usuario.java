 package com.Usuario.Foro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String username;
	private String email;
	private String contrasena;
	@JoinColumn (name = "topicos_id")
	private Long topicosId;
	@JoinColumn (name = "respuesta_id")
	private Long respuestasId;
	private Boolean usuario;
}
