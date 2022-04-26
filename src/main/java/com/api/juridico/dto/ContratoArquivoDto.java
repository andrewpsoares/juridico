package com.api.juridico.dto;

import com.api.juridico.domain.model.ContratoArquivo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ContratoArquivoDto {
    private Long id;
    private String descricao;
    private LocalDate dtRegistro;
    private byte[] arquivo;

    public ContratoArquivoDto(ContratoArquivo contratoArquivo) {
        this.id         = contratoArquivo.getId();
        this.descricao  = contratoArquivo.getDescricao();
        this.dtRegistro = contratoArquivo.getDtRegistro();
        this.arquivo    = contratoArquivo.getArquivo();
    }
}
