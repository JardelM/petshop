package com.pucminas.petshop.entity;

import com.pucminas.petshop.enuns.SituacaoPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PagDinheiro extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Double desconto;

    public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Date dataVencimento, Double desconto) {
        super(id, valor, situacao, servico);
        this.dataVencimento = dataVencimento;
        this.desconto = desconto;
    }
}
