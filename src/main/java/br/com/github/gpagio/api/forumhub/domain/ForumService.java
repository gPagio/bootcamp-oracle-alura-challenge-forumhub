package br.com.github.gpagio.api.forumhub.domain;

import br.com.github.gpagio.api.forumhub.domain.curso.Curso;
import br.com.github.gpagio.api.forumhub.domain.curso.CursoRepository;
import br.com.github.gpagio.api.forumhub.domain.curso.DadosTopicoAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosDetalhamentoTopico;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoPostagem;
import br.com.github.gpagio.api.forumhub.domain.topico.Topico;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import br.com.github.gpagio.api.forumhub.domain.topico.validacoes.ValidadorDePostagemDeTopico;
import br.com.github.gpagio.api.forumhub.domain.usuario.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorDePostagemDeTopico> validadorDePostagemDeTopicos;

    public DadosDetalhamentoTopico postar(DadosTopicoPostagem dados) {
        if (!cursoRepository.existsById(dados.idCurso())) throw new ValidacaoException("Nenhum curso cadastrado com o ID informado!");

        validadorDePostagemDeTopicos.forEach(validador -> validador.validar(dados));

        var curso = cursoRepository.findById(dados.idCurso()).get();
        var usuario = AutenticacaoService.getUsuarioLogado();
        var topico = new Topico(dados, usuario, curso);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public Object atualizar(Long id, DadosTopicoAtualizacao dados) {
        if (!topicoRepository.existsById(id)) throw new ValidacaoException("Nenhum tópico encontrado com o ID informado!");

        Curso curso = null;
        if (dados.idCurso() != null){
            if (!cursoRepository.existsById(dados.idCurso())){
                throw new ValidacaoException("Nenhum curso cadastrado com o ID informado!");
            } else {
                curso = cursoRepository.getReferenceById(dados.idCurso());
            }
        }

        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dados, curso);

        return new DadosDetalhamentoTopico(topico);
    }
}
