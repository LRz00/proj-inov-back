package com.ifba.proj_inov.api.dto.exame;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExameDto {
    private Long id;
    private String nome;
    private String descricao;
}
