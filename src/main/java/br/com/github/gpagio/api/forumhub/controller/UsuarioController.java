package br.com.github.gpagio.api.forumhub.controller;

import br.com.github.gpagio.api.forumhub.domain.usuario.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity listarTodosUsuarios(@Parameter(hidden = true) @PageableDefault(size = 10, sort = "id") Pageable paginacao,
                                              @RequestParam(required = true, name = "ativo") Boolean ativo){
        var page = usuarioService.listar(paginacao, ativo);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosUsuarioCadastro dados, UriComponentsBuilder uriBuilder){
        var dadosDetalhamentoUsuario = usuarioService.cadastrar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dadosDetalhamentoUsuario.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoUsuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosUsuarioAtualizacao dados){
        var dadosDetalhamentoUsuario = usuarioService.atualizar(id, dados);
        return ResponseEntity.ok(dadosDetalhamentoUsuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        usuarioService.desativar(id);
        return ResponseEntity.noContent().build();
    }

}
