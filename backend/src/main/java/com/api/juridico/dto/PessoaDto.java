package com.api.juridico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String tipoPessoa;
}
