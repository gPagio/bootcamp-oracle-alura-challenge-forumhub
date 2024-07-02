package br.com.github.gpagio.api.forumhub.domain.resposta;

import jakarta.validation.constraints.NotNull;

public record DadosRespostaAtualizacao(String mensagem,
                                       String solucao) {
}
