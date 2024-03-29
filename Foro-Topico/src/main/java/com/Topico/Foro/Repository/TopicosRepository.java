package com.Topico.Foro.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Topico.Foro.entity.Topico;

public interface TopicosRepository extends JpaRepository<Topico, Long> {

	Page<Topico> findAllByExiste(Pageable paginacion);

}
