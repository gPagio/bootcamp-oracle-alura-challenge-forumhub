package br.com.github.gpagio.api.forumhub.controller;

import br.com.github.gpagio.api.forumhub.domain.ForumService;
import br.com.github.gpagio.api.forumhub.domain.curso.DadosTopicoAtualizacao;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosDetalhamentoTopico;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoPostagem;
import br.com.github.gpagio.api.forumhub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ForumService forumService;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosTopicoPostagem dados, UriComponentsBuilder uriBuilder){
        var dadosDetalhamentoTopico = forumService.postar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dadosDetalhamentoTopico.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoTopico);
    }

    @GetMapping
    public ResponseEntity listarTodosOsTopicos(@PageableDefault(size = 10, sort = "id") Pageable paginacao){
        var page = topicoRepository.findAll(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping
    @RequestMapping("/filtro")
    public ResponseEntity listarTodosOsTopicosPorAnoECurso(@PageableDefault(size = 10, sort = "id") Pageable paginacao,
                                                           @RequestParam(required = true, name = "curso") String curso,
                                                           @RequestParam(required = true, name = "ano") Integer ano){
        Page<DadosDetalhamentoTopico> page = topicoRepository.findAllByAnoAndCursoIngoreCase(paginacao, curso, ano).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTopicoEspecifico (@PathVariable Long id){
        var dadosDetalhamentoTopico = new DadosDetalhamentoTopico(topicoRepository.getReferenceById(id));
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody DadosTopicoAtualizacao dados){
        var dadosDetalhamentoTopico = forumService.atualizar(id, dados);
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }
}
