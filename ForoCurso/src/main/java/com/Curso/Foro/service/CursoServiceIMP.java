package com.Curso.Foro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Curso.Foro.client.TopicoClient;
import com.Curso.Foro.controller.TopicoDTO;
import com.Curso.Foro.entity.Curso;
import com.Curso.Foro.http.response.TopicoByCurso;
import com.Curso.Foro.repository.CursoRepository;

@Service
public class CursoServiceIMP implements CursoService{

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TopicoClient topicoClient;
	
	@Override
	public List<Curso> findAllCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TopicoByCurso findAllTopicoByIdCurso(Long idCurso) {
		// obtener curso
		Curso curso = cursoRepository.findById(idCurso).orElse(new Curso());
		//obtener Topico
		List<TopicoDTO> topicoDTO = topicoClient.findAllTopicoByCursoId(idCurso);
		
		return TopicoByCurso.builder()
				.nombre(curso.getNombre())
				.categoria(curso.getCategoria())
				.topicoDTO(topicoDTO)
				.build();
	}

}
