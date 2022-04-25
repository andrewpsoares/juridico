package com.api.juridico.dto;

import com.api.juridico.config.ObjectMapperConfig;
import com.api.juridico.domain.model.*;
import com.api.juridico.domain.model.enumerator.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ContratoDto {
    private Long id;
    private Long numero;
    private EnumTipoContrato tipoContrato;
    private PessoaDto empContratada;
    private PessoaDto empContratante;
    private String objeto;
    private EnumSetor setor;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private EnumSituacao situacao;
    private String observacao;
    private BigDecimal vlrContrato;

    public ContratoDto(Contrato contrato) {
        this.id             = contrato.getId();
        this.numero         = contrato.getNumero();
        this.tipoContrato   = contrato.getTipoContrato();
        this.empContratada  = ObjectMapperConfig.map(contrato.getEmpContratada(), PessoaDto.class);
        this.empContratante = ObjectMapperConfig.map(contrato.getEmpContratante(), PessoaDto.class);
        this.objeto         = contrato.getObjeto();
        this.setor          = contrato.getSetor();
        this.dtInicio       = contrato.getDtInicio();
        this.dtFim          = contrato.getDtFim();
        this.situacao       = contrato.getSituacao();
        this.observacao     = contrato.getObservacao();
        this.vlrContrato    = contrato.getVlrContrato();
    }
}
