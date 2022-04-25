package com.api.juridico.dto;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.enumerator.EnumStatusProcesso;
import com.api.juridico.domain.model.enumerator.EnumTipoProcesso;
import com.api.juridico.domain.model.Processo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProcessoDto {
    private Long id;
    private Integer numero;
    private PessoaDto autor;
    private PessoaDto reu;
    private BigDecimal vlrCausa;
    private EnumStatusProcesso status;
    private EnumTipoProcesso tipo;
    private LocalDate dtInclusao;
    private LocalDate dtUltimaMov;
    private String local;
    private BigDecimal vlrDespesas;

    public ProcessoDto(Processo processo) {
        this.id          = processo.getId();
        this.numero      = processo.getNumero();
        this.autor       = ObjectMapperConfig.map(processo.getAutor(), PessoaDto.class);
        this.reu         = ObjectMapperConfig.map(processo.getReu(), PessoaDto.class);
        this.vlrCausa    = processo.getVlrCausa();
        this.status      = processo.getStatus();
        this.tipo        = processo.getTipo();
        this.dtInclusao  = processo.getDtInclusao();
        this.dtUltimaMov = processo.getDtUltimaMov();
        this.local       = processo.getLocal();
        this.vlrDespesas = processo.getVlrDespesas();
    }
}
