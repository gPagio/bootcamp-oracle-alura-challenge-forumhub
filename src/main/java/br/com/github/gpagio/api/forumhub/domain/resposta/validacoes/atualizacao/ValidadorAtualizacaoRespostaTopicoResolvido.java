package br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.resposta.DadosRespostaAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.resposta.RespostaRepository;
import br.com.github.gpagio.api.forumhub.domain.topico.StatusTopico;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaTopicoResolvido implements ValidadorDeAtualizacaoResposta {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idResposta, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        var resposta = respostaRepository.getReferenceById(idResposta);
        if (StatusTopico.RESOLVIDO.equals(topicoRepository.getReferenceById(resposta.getTopico().getId()).getStatus())){
            throw new ValidacaoException("Tópicos resolvidos não permitem edição de suas respostas!");
        }
    }
}
