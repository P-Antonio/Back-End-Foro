package com.Topico.Foro.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
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
@Table(name = "Topicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;

	@JoinColumn(name = "fecha_creacion")
	private LocalDateTime fechaCreacion = LocalDateTime.now();

	private StatusTopico status = StatusTopico.NO_RESPONDIDO;
	private Long autorId;

	@JoinColumn(name = "curso_id")
	private Long cursoId;

	@JoinColumn(name = "respuestas_id")
	private Long respuestasId;
	private Boolean existe;

	public Topico(@Valid datosTopico datos) {
		this.id = datos.id();
		this.titulo = datos.Titulo();
		this.mensaje = datos.mensaje();
		this.fechaCreacion = datos.fechaCreacion();
		this.status = datos.status();
		this.cursoId = datos.cursoId();
		this.respuestasId = datos.respuestaId();
		this.existe = datos.existe();
	}

	public void putTopico(actualizarTopico put) {
		if(put.titulo() !=  null) {
			this.titulo = put.titulo() ;
		}
		if(put.mensaje() != null) {
			this.mensaje = put.mensaje();
		}
	}

	public void eliminar() {
		this.existe = false;
		
	}
}
