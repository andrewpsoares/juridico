package com.api.juridico.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ContratoArquivos {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private Contrato contrato;

    private String descricao;

    private File arquivo;

    private LocalDate dtGeracao = LocalDate.now();
}
