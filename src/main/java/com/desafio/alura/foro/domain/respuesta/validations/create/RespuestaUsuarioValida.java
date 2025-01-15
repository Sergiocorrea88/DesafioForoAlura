package com.desafio.alura.foro.domain.respuesta.validations.create;

import com.desafio.alura.foro.domain.respuesta.dto.CrearRespuestaDTO;
import com.desafio.alura.foro.domain.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaUsuarioValida implements ValidarRespuestaCreada{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearRespuestaDTO data) {
        var usuarioExiste = repository.existsById(data.usuarioId()); // Parece incompleto: data.usuario

        if (!usuarioExiste) {
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().isEnabled(); // Parece incompleto: data.usuario

        if (!usuarioHabilitado) {
            throw new ValidationException("Este usuario no esta habilitado");
        }
    }
}

