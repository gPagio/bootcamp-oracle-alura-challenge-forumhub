package br.com.github.gpagio.api.forumhub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosCursoCadastro(@NotNull(message = "Nome do curso deve ser informado para cadastrar um curso!")
                                 String nome,

                                 @NotNull(message = "Categoria do curso deve ser informada para cadastrar um curso!")
                                 CategoriaCurso categoriaCurso) {
}
