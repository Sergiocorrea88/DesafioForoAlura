package com.desafio.alura.foro.domain.topico.dto;

import com.desafio.alura.foro.domain.topico.Estado;

public record ActualizarTopicoDTO(
        String titulo,
        String mensaje,
        Estado estado,
        Long cursoId
) {
}
