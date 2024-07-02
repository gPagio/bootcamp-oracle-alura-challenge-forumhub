package br.com.github.gpagio.api.forumhub.domain.topico.validacoes.atualizacao;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoTopicoTituloRepetido implements ValidadorDeAtualizacaoDeTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dadosTopicoAtualizacao) {
        if (dadosTopicoAtualizacao.titulo() != null && topicoRepository.existsByTituloIgnoreCase(dadosTopicoAtualizacao.titulo().trim())) {
            throw new ValidacaoException("Já existe um tópico criado com esse título!");
        }
    }
}
