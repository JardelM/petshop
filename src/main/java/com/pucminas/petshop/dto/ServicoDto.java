package com.pucminas.petshop.dto;

import com.pucminas.petshop.entity.Cliente;
import com.pucminas.petshop.entity.Pagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServicoDto {

    private Integer id;
    private Date dataEntrada;
    private Date dataSaida;
    private String descricao;
    private Pagamento pagamento;
}
