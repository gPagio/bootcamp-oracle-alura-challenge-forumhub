package br.com.github.gpagio.api.forumhub.domain.usuario.validacoes.atualizar;

import br.com.github.gpagio.api.forumhub.domain.usuario.DadosUsuarioAtualizacao;

public interface ValidadorDeAtualizacaoDeUsuario {

    void validar(DadosUsuarioAtualizacao dados);
}
