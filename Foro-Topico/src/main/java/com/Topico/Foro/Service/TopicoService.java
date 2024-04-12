package com.Topico.Foro.Service;

import com.Topico.Foro.http.response.RespuestaByTopico;

public interface TopicoService {

	RespuestaByTopico findRespuestaByIdTopico (Long idTopico);
}
