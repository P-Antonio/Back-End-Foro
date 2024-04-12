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

	//@Query ("SELECT c FROM Cursos c WHERE c.nombre = nombre")
	Page<Curso> findAllByNombreIsTrue (Pageable pagination);

	
}
