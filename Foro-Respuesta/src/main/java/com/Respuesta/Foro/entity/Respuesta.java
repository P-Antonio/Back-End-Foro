package com.Respuesta.Foro.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name ="Respuestas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@JoinColumn(name = "topico_id")
	private Long topicoId;
	@JoinColumn (name = "fecha_creacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	@JoinColumn (name = "autor_id")
	private Long autorId;
	private Boolean solucion = false;
	
	public Respuesta(@Valid datosRespuesta datos) {
		this.id = datos.id();
		this.mensaje = datos.mensaje();
		this.topicoId = datos.topicoId();
		this.fechaCreacion = datos.fechaCreacion();
		this.autorId = datos.autorId();
		this.solucion = datos.solucion();
	}

	public void putRespuesta(@Valid actRespuesta respuesta) {
		if(respuesta.id() != null) {
			this.id = respuesta.id();
		}
		if(respuesta.mensaje() != null) {
			this.mensaje = respuesta.mensaje();
		}
	}
}
