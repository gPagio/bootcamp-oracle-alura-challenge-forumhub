package br.com.github.gpagio.api.forumhub.domain.topico;

import br.com.github.gpagio.api.forumhub.domain.curso.Curso;
import br.com.github.gpagio.api.forumhub.domain.usuario.DadosDetalhamentoUsuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id,
                                      String titulo,
                                      String mensagem,
                                      LocalDateTime dataCriacao,
                                      StatusTopico status,
                                      DadosDetalhamentoUsuario usuario,
                                      Curso curso) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), new DadosDetalhamentoUsuario(topico.getUsuario()), topico.getCurso());
    }
}
