package br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.resposta.DadosRespostaAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.topico.StatusTopico;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaTopicoResolvido implements ValidadorDeAtualizacaoResposta {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long idTopico, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        if (StatusTopico.RESOLVIDO.equals(topicoRepository.getReferenceById(idTopico).getStatus())){
            throw new ValidacaoException("Tópicos resolvidos não permitem edição de suas respostas!");
        }
    }
}
