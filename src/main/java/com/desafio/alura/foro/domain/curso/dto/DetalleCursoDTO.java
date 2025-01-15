package com.desafio.alura.foro.domain.curso.dto;

import com.desafio.alura.foro.domain.curso.Categoria;
import com.desafio.alura.foro.domain.curso.Curso;

public record DetalleCursoDTO(

        Long id,
        String name,
        Categoria categoria,
        Boolean activo) {

    public DetalleCursoDTO(Curso curso){
        this(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo());
    }
}
