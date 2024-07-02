package br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.postagem;

import br.com.github.gpagio.api.forumhub.domain.resposta.DadosRespostaPostagem;

public interface ValidadorDePostagemDeResposta {

    void validar(Long idTopico, DadosRespostaPostagem dadosRespostaPostagem);

}
