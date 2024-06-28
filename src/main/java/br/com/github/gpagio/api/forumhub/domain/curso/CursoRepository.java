package br.com.github.gpagio.api.forumhub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {
    Boolean existsByNomeIgnoreCase(String nome);
}
