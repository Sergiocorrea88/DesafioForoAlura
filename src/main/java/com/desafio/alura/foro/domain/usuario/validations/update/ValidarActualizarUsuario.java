package com.desafio.alura.foro.domain.usuario.validations.update;


import com.desafio.alura.foro.domain.usuario.dto.ActualizarUsuarioDTO;

public interface ValidarActualizarUsuario {
    void validate(ActualizarUsuarioDTO data);
}
