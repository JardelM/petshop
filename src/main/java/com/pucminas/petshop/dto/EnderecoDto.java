package com.pucminas.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
}
