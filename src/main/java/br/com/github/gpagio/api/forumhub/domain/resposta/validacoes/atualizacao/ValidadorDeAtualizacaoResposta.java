package br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.resposta.DadosRespostaAtualizacao;

public interface ValidadorDeAtualizacaoResposta {

    void validar(Long idResposta, DadosRespostaAtualizacao dadosRespostaAtualizacao);

}
