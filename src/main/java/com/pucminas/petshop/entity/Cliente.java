package com.pucminas.petshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Cliente extends Pessoa {


    private static final long serialVersionUID = 1L;

    private String tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    List<Servico> servicos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String codNacional, String tipo) {
        super(id, nome, email, codNacional);
        this.tipo = tipo;
    }
}
