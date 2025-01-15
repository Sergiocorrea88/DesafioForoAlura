package com.desafio.alura.foro.domain.respuesta.dto;


public record ActualizarRespuestaDTO(
        String mensaje,
        Boolean  solucion,
        Boolean borrado
) {
}
