package br.com.github.gpagio.api.forumhub.domain.topico.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.topico.StatusTopico;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoTopicoResolvido implements ValidadorDeAtualizacaoDeTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dadosTopicoAtualizacao) {
        if (StatusTopico.RESOLVIDO.equals(topicoRepository.getReferenceById(id).getStatus())){
            throw new ValidacaoException("Tópicos resolvidos não podem ser atualizados!");
        }
    }
}
