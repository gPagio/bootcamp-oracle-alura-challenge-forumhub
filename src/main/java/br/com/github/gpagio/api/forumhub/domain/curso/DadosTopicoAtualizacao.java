package br.com.github.gpagio.api.forumhub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosTopicoAtualizacao(String titulo,
                                     String mensagem,
                                     Long idCurso) {
}
