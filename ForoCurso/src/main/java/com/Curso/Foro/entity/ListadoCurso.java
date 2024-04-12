package com.Curso.Foro.entity;

public record ListadoCurso(String nombre, String categoria, Long topicosId) {

	public ListadoCurso(Curso guardarCurso) {
		this(guardarCurso.getNombre(), guardarCurso.getCategoria(), guardarCurso.getTopicosId());
	}

}
