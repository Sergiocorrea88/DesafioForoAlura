package com.desafio.alura.foro.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByUsername (String username);
    UserDetails findByEmail(String email);
    Page<Usuario> findAllByEnabledTrue(Pageable pageable);
    Usuario getReferenceById(Long id);
    Page<Usuario> findAll (Pageable pageable);
    Usuario getReferenceByUsername(String username);
    Boolean existsByUsername(String username);
}
