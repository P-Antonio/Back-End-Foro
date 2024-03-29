package com.Usuario.Foro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Usuario.Foro.Repository.UsuarioRepository;
import com.Usuario.Foro.entity.DatosListadoUsuario;
import com.Usuario.Foro.entity.Usuario;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping ("/Usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<Page<DatosListadoUsuario>> verUsuaios(@PageableDefault (size = 5, sort = {"username"})Pageable paginacion) {
		var page = usuarioRepository.findAllByUsuarioTrue(paginacion).map(DatosListadoUsuario :: new);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping ({"/id"})
	public ResponseEntity<DatosListadoUsuario> verUnUsuario(@PathVariable Long id){
		var usuario = usuarioRepository.getReferenceById(id);
		return ResponseEntity.ok(new DatosListadoUsuario(usuario));
	}
}
