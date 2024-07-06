package com.sistema_campanha.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;



@Entity
@Table(name = "tb_campanha")
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCampanha;
    private String meta;
    private String orcamento;
    private String publico;
    private String observacao;
    private Instant criacao;
    private Instant dateStart;
    private Instant dateEnd;

    public Campanha() {
    }

    public Campanha(String publico, String orcamento, String observacao, String nomeCampanha, String meta, Instant dateStart, Instant dateEnd, Instant criacao) {
        this.publico = publico;
        this.orcamento = orcamento;
        this.observacao = observacao;
        this.nomeCampanha = nomeCampanha;
        this.meta = meta;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.criacao = criacao;
    }
}




