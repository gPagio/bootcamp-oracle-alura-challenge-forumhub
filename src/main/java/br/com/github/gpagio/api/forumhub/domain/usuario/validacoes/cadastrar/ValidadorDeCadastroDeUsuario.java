package br.com.github.gpagio.api.forumhub.domain.usuario.validacoes.cadastrar;

import br.com.github.gpagio.api.forumhub.domain.usuario.DadosUsuarioCadastro;

public interface ValidadorDeCadastroDeUsuario {

    void validar(DadosUsuarioCadastro dados);

}
