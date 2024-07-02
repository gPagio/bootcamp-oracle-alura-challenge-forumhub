package br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.resposta.DadosRespostaAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.resposta.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaSolucaoRepetida implements ValidadorDeAtualizacaoResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idTopico, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        if (dadosRespostaAtualizacao.solucao() != null && respostaRepository.optionalRespostaByIdTopicoAndSolucaoIgnoreCase(idTopico, dadosRespostaAtualizacao.solucao().trim()).isPresent()){
            throw new ValidacaoException("Já existe uma resposta para este tópico com essa solução!");
        }
    }
}
