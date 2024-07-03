package br.com.github.gpagio.api.forumhub.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    UserDetails findByEmail(String email);

    Boolean existsByEmail(String email);

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
}