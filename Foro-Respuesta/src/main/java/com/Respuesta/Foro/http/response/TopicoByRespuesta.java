package com.Respuesta.Foro.http.response;

import java.util.List;

import com.Respuesta.Foro.controller.TopicoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicoByRespuesta {

	private Long autor;
	private String mensaje;
	private List<TopicoDTO> topico;
}
