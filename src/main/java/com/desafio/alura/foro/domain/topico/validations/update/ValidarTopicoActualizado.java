package com.desafio.alura.foro.domain.topico.validations.update;

import com.desafio.alura.foro.domain.topico.dto.ActualizarTopicoDTO;

public interface ValidarTopicoActualizado {
    void validate(ActualizarTopicoDTO data);
}
