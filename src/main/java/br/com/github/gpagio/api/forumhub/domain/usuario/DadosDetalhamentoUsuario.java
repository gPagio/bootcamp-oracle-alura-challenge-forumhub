package br.com.github.gpagio.api.forumhub.domain.usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, Boolean ativo) {

    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getAtivo());
    }
}
