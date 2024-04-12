package com.Topico.Foro.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Topico.Foro.entity.Topico;
@Repository
public interface TopicosRepository extends JpaRepository<Topico, Long> {

	Page<Topico> findAllByExisteIsTrue(Pageable paginacion);

	List<Topico> findByRespuestasId(Long idRespuesta);

}
