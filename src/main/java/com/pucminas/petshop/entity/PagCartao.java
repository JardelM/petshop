package com.pucminas.petshop.entity;

import com.pucminas.petshop.enuns.SituacaoPagamento;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class PagCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Integer parcelas;

    public PagCartao(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Integer parcelas) {
        super(id, valor, situacao, servico);
        this.setParcelas(parcelas);
    }
}
