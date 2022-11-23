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
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 1L;

    private String funcao;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    List<Servico> servicos = new ArrayList<>();

    public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
        super(id, nome, email, codNacional);
        this.funcao = funcao;
    }

}
