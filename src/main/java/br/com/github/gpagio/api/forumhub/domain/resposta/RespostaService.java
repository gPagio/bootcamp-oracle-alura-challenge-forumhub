package br.com.github.gpagio.api.forumhub.domain.resposta;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.atualizacao.ValidadorDeAtualizacaoResposta;
import br.com.github.gpagio.api.forumhub.domain.resposta.validacoes.postagem.ValidadorDePostagemDeResposta;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorDePostagemDeResposta> validadorDePostagemDeResposta;

    @Autowired
    private List<ValidadorDeAtualizacaoResposta> validadorDeAtualizacaoRespostas;

    public DadosDetalhamentoResposta postar(Long idTopico, DadosRespostaPostagem dados) {
        if (!topicoRepository.existsById(idTopico)) throw new ValidacaoException("Nenhum tópico encontrado com o ID fornecido!");

        validadorDePostagemDeResposta.forEach(validador -> validador.validar(idTopico, dados));

        var topico = topicoRepository.getReferenceById(idTopico);
        var resposta = new Resposta(topico, dados);

        respostaRepository.save(resposta);

        return new DadosDetalhamentoResposta(resposta);
    }

    public DadosDetalhamentoResposta atualizar(Long idTopico, Long idResposta, DadosRespostaAtualizacao dados) {
        if (!topicoRepository.existsById(idTopico)) throw new ValidacaoException("Nenhum tópico encontrado com o ID fornecido!");

        validadorDeAtualizacaoRespostas.forEach(validador -> validador.validar(idTopico, dados));

        var optionalResposta = respostaRepository.getReferenceByIdAndTopicoId(idTopico, idResposta);
        if (optionalResposta.isEmpty()) throw new ValidacaoException("Nenhuma resposta encontrada para os IDs de tópico e resposta fornecidos!");

        var resposta = optionalResposta.get();
        resposta.atualizar(dados);

        return new DadosDetalhamentoResposta(resposta);
    }
}
