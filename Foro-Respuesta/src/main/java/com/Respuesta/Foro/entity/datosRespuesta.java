package com.Respuesta.Foro.entity;

import java.time.LocalDateTime;

public record datosRespuesta(Long id, String mensaje, Long topicoId, LocalDateTime fechaCreacion, Long autorId, Boolean solucion) {

}
