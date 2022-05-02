package com.api.juridico.dto;

import com.api.juridico.domain.model.Ocorrencia;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class OcorrenciaDto {
    private Long id;
    private String descricao;
    private LocalDate dtRegistro;

    public OcorrenciaDto(Ocorrencia ocorrecia) {
        this.id = ocorrecia.getId();
        this.descricao = ocorrecia.getDescricao();
        this.dtRegistro = ocorrecia.getDtRegistro();
    }
}
