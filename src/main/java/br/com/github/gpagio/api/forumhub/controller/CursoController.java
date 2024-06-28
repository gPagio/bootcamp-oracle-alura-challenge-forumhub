package br.com.github.gpagio.api.forumhub.controller;

import br.com.github.gpagio.api.forumhub.domain.curso.CursoService;
import br.com.github.gpagio.api.forumhub.domain.curso.DadosCursoCadastro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCursoCadastro dados){
        var dadosDetalhamentoCurso = cursoService.cadastrar(dados);
        return ResponseEntity.ok(dadosDetalhamentoCurso);
    }

}
