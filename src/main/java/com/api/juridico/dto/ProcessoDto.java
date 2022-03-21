package com.api.juridico.dto;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.Processo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProcessoDto {
    private Long id;
    private Integer numero;
    private PessoaDto autor;
    private BigDecimal vlrCausa;

    public ProcessoDto(Processo processo) {
        this.id = processo.getId();
        this.numero = processo.getNumero();
        this.autor = ObjectMapperConfig.map(processo.getAutor(), PessoaDto.class);
        this.vlrCausa = processo.getVlrCausa();
    }
}
