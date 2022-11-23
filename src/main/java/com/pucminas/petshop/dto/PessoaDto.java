package com.pucminas.petshop.dto;

import com.pucminas.petshop.entity.Endereco;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDto {

    private Integer id;
    private String nome;
    private String email;
    private String codNacional;
    private Set<String> telefones = new HashSet<>();
    private List<EnderecoDto> enderecos;

}
