package com.api.juridico.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Processo {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "reu_id")
    private Reu reu;

    private BigDecimal vlrCausa;

    @Enumerated(EnumType.STRING)
    private EnumStatusProcesso status;

    @Enumerated(EnumType.STRING)
    private EnumTipoProcesso tipo;

    private LocalDate dtInclusao;

    private LocalDate dtUltimaMov;

    private String local;

    private BigDecimal vlrDespesas;

    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrecias = new ArrayList<>();

    public Ocorrencia insertOcorrencia(String descricao){
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDtRegistro(LocalDate.now());
        ocorrencia.setProcesso(this);
        this.getOcorrecias().add(ocorrencia);
        return ocorrencia;
    }

    public void finalizar(){
        if (naoPodeFinalizar()) {
            throw new RuntimeException("Entrega não pode ser finalizada");
        }

        setStatus(EnumStatusProcesso.FINALIZADO);
        setDtUltimaMov(LocalDate.now());
    }

    public boolean podeFinalizar() {
        return (EnumStatusProcesso.ABERTO.equals(getStatus())) ||
                (EnumStatusProcesso.AGUARDANDO.equals(getStatus()));
    }

    public boolean naoPodeFinalizar() {
        return !podeFinalizar();
    }
}
