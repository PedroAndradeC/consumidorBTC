package com.jornada.consumidor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PostDTO {
    @Schema(description = "Qualquer ID genérico", example = "1")
    @Positive
    private Integer idPost;
    @Schema(description = "Colocar titulo do Post", example = "Lorem Ipsum Sit Dolor Amet")
    @NotBlank
    @NotNull
    private String title;
    @Schema(description = "Colocar Conteudo do Post", example = "Lorem Ipsum Sit Dolor Amet")
    @NotBlank
    @NotNull
    private String contents;

//    private UserRetornoDTO user;
}

