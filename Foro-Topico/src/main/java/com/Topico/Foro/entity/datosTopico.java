package com.Topico.Foro.entity;

import java.time.LocalDateTime;

public record datosTopico(Long id, String Titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico status, Long cursoId, Long respuestaId, Boolean existe) {

}
