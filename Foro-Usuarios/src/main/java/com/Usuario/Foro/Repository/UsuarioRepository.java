package com.Usuario.Foro.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Usuario.Foro.entity.DatosListadoUsuario;
import com.Usuario.Foro.entity.Usuario;
import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Page<Usuario> findAllByUsuarioTrue (Pageable paginacion);
}
