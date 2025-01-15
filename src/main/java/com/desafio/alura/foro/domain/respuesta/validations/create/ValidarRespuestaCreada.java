package com.desafio.alura.foro.domain.respuesta.validations.create;

import com.desafio.alura.foro.domain.respuesta.dto.CrearRespuestaDTO;

public interface ValidarRespuestaCreada {
    void validate(CrearRespuestaDTO data);
}
