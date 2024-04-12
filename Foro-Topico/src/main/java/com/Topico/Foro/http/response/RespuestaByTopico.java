package com.Topico.Foro.http.response;

import java.util.List;

import com.Topico.Foro.Controller.RespuestaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaByTopico {

	private String titulo;
	private String mensaje;
	private List<RespuestaDTO> respuestaDTO;
}
