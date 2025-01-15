package com.desafio.alura.foro.domain.respuesta.validations.update;

import com.desafio.alura.foro.domain.respuesta.dto.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    void validate(ActualizarRespuestaDTO data, Long respuestaId);
}
