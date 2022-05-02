package com.api.juridico.domain.model;

import com.api.juridico.domain.model.enumerator.EnumSetor;
import com.api.juridico.domain.model.enumerator.EnumSituacao;
import com.api.juridico.domain.model.enumerator.EnumTipoContrato;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Contrato {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CONTRATO")
    private Long id;

    @Column(name = "NUMERO_CONTRATO")
    @NotNull
    private Long numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CONTRATO")
    private EnumTipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name = "empcontratada_id")
    @NotNull
    private EmpContratada empContratada;

    @ManyToOne
    @JoinColumn(name = "empcontratante_id")
    @NotNull
    private EmpContratante empContratante;

    @Column(name = "OBJETO_CONTRATO")
    private String objeto;

    @Enumerated(EnumType.STRING)
    @Column(name = "SETOR_CONTRATO")
    private EnumSetor setor;

    @Column(name = "DTINICIO_CONTRATO")
    private LocalDate dtInicio;

    @Column(name = "DTFIM_CONTRATO")
    private LocalDate dtFim;

    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO_CONTRATO")
    private EnumSituacao situacao;

    @Column(name = "OBSERVACAO_CONTRATO")
    private String observacao;

    @OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL)
    private List<ContratoArquivo> arquivos = new ArrayList<>();

    @Column(name = "VLR_CONTRATO")
    private BigDecimal vlrContrato;

    public ContratoArquivo insertFile(Long idContrato, MultipartFile file) throws IOException {
        ContratoArquivo contratoArquivos = new ContratoArquivo();
        contratoArquivos.setDescricao(file.getResource().getFilename());
        contratoArquivos.setArquivo(file.getBytes());
        contratoArquivos.setContrato(this);
        this.getArquivos().add(contratoArquivos);
        return contratoArquivos;
    }
}
