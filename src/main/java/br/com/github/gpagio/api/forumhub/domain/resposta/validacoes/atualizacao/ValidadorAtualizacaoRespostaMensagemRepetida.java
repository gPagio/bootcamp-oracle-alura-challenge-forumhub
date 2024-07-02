package br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.resposta.DadosRespostaAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.resposta.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaMensagemRepetida implements ValidadorDeAtualizacaoResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idTopico, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        if (dadosRespostaAtualizacao.mensagem() != null && respostaRepository.optionalRespostaByIdTopicoAndMensagemIgnoreCase(idTopico, dadosRespostaAtualizacao.mensagem().trim()).isPresent()){
            throw new ValidacaoException("Já existe uma resposta para este tópico com essa mensagem!");
        }
    }
}
