package com.desafio.alura.foro.infra.security;

import com.desafio.alura.foro.domain.usuario.UsuarioRepository;
import com.desafio.alura.foro.infra.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var authHeader = request.getHeader("Authorization");

        logger.info("Authorization Header: {}", authHeader);

        if (authHeader != null) {
            try {
                var token = authHeader.replace("{Bearer} ", "");
                logger.info("Extracted Token: {}", token);

                var username = tokenService.getSubject(token);
                logger.info("Extracted Username: {}", username);

                if (username != null) {
                    var usuario = usuarioRepository.findByUsername(username);
                    logger.info("Found Usuario: {}", usuario);

                    if (usuario != null) { // Verifica si el usuario existe en la base de datos
                        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        logger.warn("Usuario not found in database for username: {}", username);
                    }
                } else {
                    logger.warn("Username is null after token extraction. Invalid or expired token.");
                }
            } catch (Exception e) {
                logger.error("Error processing token: {}", e.getMessage(), e); // Log de la excepción completa
            }
        } else {
            logger.warn("Authorization header is null.");
        }

        filterChain.doFilter(request, response);
    }
}