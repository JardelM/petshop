package com.pucminas.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucminas.petshop.enuns.SituacaoPagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Double valor;
    private SituacaoPagamento situacao;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_servico")
    @MapsId
    private Servico servico;
}
