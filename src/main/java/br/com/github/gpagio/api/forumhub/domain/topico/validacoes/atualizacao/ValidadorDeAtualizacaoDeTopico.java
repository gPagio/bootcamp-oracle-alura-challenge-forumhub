package br.com.github.gpagio.api.forumhub.domain.topico.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoAtualizacao;

public interface ValidadorDeAtualizacaoDeTopico {

    void validar(Long id, DadosTopicoAtualizacao dadosTopicoAtualizacao);

}
