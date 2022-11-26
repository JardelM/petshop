package com.pucminas.petshop.dto;

import com.pucminas.petshop.entity.Especie;
import com.pucminas.petshop.entity.Raca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private Integer id;
    private String nome;
    private Integer idade;
}
