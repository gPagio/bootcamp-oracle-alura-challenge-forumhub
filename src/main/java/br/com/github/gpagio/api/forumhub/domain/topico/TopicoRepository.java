package br.com.github.gpagio.api.forumhub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository <Topico, Long> {

    Boolean existsByTituloIgnoreCase(String titulo);

    Boolean existsByMensagemIgnoreCase(String mensagem);
}
