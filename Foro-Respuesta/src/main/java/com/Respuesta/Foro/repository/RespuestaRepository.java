package com.Respuesta.Foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Respuesta.Foro.entity.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}
