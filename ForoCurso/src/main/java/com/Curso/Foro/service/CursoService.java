package com.Curso.Foro.service;

import java.util.List;

import com.Curso.Foro.entity.Curso;
import com.Curso.Foro.http.response.TopicoByCurso;

public interface CursoService {

	List<Curso> findAllCursos ();
	Curso findById (Long id);
	void save (Curso curso);
	TopicoByCurso findAllTopicoByIdCurso (Long idCurso);
}
