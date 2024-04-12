package com.Curso.Foro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Curso.Foro.entity.Curso;
import java.util.List;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	Page<Curso> findAllByNombreIsTrue (Pageable pagination);
	
	List<Curso> findByTopicosId (Long topicosId);

	
}
