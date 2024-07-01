package br.com.github.gpagio.api.forumhub.domain.topico.validacoes.postagem;

import br.com.github.gpagio.api.forumhub.domain.ValidacaoException;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoPostagem;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorNovoTopicoComTituloIgualATopicoExistente implements ValidadorDePostagemDeTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosTopicoPostagem dadosTopicoPostagem) {
        if (topicoRepository.existsByTituloIgnoreCase(dadosTopicoPostagem.titulo().trim())) throw new ValidacaoException("Já existe um tópico criado com esse título!");
    }
}
