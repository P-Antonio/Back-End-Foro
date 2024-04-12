package com.Curso.Foro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Cursos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String categoria;
	
	@Column (name = "topicos_id")
	private Long topicosId;
	

	public Curso(@Valid DatosCurso curso) {
		this.id = curso.id();
		this.nombre = curso.nombre();
		this.categoria = curso.categoria();
		this.topicosId = curso.topicosId();
	}


	public void ActualizarCurso(@Valid ActualizarCurso curso) {
		if(curso.nombre() != null) {
			this.nombre = curso.nombre();
		}
		if(curso.Categoria() != null) {
			this.categoria = curso.Categoria();
		}
		
	}
}
