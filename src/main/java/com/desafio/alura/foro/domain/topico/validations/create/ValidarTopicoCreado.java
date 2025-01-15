package com.desafio.alura.foro.domain.topico.validations.create;

import com.desafio.alura.foro.domain.topico.dto.CrearTopicoDTO;

public interface ValidarTopicoCreado {

    void validate(CrearTopicoDTO data);
}
