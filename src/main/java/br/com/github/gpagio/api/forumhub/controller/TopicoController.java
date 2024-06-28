package br.com.github.gpagio.api.forumhub.controller;

import br.com.github.gpagio.api.forumhub.domain.ForumService;
import br.com.github.gpagio.api.forumhub.domain.topico.DadosTopicoPostagem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ForumService forumService;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosTopicoPostagem dados){
        var dadosDetalhamentoTopico = forumService.postar(dados);
        return ResponseEntity.ok(dadosDetalhamentoTopico);
    }

}
