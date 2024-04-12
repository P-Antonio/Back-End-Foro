package com.Respuesta.Foro.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Respuesta.Foro.entity.Respuesta;
import com.Respuesta.Foro.entity.datosRespuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

	Page<Respuesta> findAllBySolucionIsTrue(Pageable pagination);

	void save(datosRespuesta respuesta);

	List<Respuesta> findByTopicoId(Long idTopico);

}
