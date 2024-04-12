package com.Curso.Foro.http.response;

import java.util.List;

import com.Curso.Foro.controller.TopicoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicoByCurso {

	private String nombre;
	private String categoria;
	private List<TopicoDTO> topicoDTO;
}
