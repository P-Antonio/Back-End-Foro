package com.Topico.Foro.Controller;

import java.time.LocalDateTime;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaDTO {

	private String mensaje;
	private Long topicoId;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private Long autorId;
	private Boolean solucion = false;
}
