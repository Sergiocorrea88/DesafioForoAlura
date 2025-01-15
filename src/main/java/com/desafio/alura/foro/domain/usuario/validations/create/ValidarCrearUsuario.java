package com.desafio.alura.foro.domain.usuario.validations.create;

import com.desafio.alura.foro.domain.usuario.dto.CrearUsuarioDTO;

public interface ValidarCrearUsuario {
    void validate(CrearUsuarioDTO data);
}
