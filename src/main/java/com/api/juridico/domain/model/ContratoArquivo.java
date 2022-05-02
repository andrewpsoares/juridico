package com.api.juridico.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ContratoArquivo {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    private Contrato contrato;

    private String descricao;

    @Lob
    private byte[] arquivo;

    private LocalDate dtRegistro = LocalDate.now();
}
