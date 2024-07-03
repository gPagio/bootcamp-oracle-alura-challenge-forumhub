package br.com.github.gpagio.api.forumhub.controller;


import br.com.github.gpagio.api.forumhub.domain.resposta.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Resposta")
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private RespostaService respostaService;

    @GetMapping("/{idTopico}")
    public ResponseEntity listarRespostasTopicoEspecifico(@PathVariable Long idTopico, @Parameter(hidden = true) @PageableDefault(size = 10, sort = "id") Pageable paginacao){
        var page = respostaRepository.findAllByTopicoId(paginacao, idTopico).map(DadosDetalhamentoResposta::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/{idTopico}")
    @Transactional
    public ResponseEntity postar(@PathVariable Long idTopico, @RequestBody @Valid DadosRespostaPostagem dados, UriComponentsBuilder uriBuilder){
        var dadosDetalhamentoResposta = respostaService.postar(idTopico, dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dadosDetalhamentoResposta.id()).toUri();
        return ResponseEntity.created(uri).body(dadosDetalhamentoResposta);
    }

    @PutMapping("/{idResposta}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long idResposta, @RequestBody DadosRespostaAtualizacao dados){
        var dadosDetalhamentoResposta = respostaService.atualizar(idResposta, dados);
        return ResponseEntity.ok(dadosDetalhamentoResposta);
    }

    @DeleteMapping
    @Transactional
    public void excluir(){

    }

}
