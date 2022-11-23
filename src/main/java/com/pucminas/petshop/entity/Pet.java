package com.pucminas.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String nome;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "id_raca")
    private Raca raca;

    @OneToMany(mappedBy = "pet")
    private List<Servico> servicos = new ArrayList<>();

    public Pet(Integer id, String nome, Integer idade, Especie especie, Raca raca) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.raca = raca;
    }
}
