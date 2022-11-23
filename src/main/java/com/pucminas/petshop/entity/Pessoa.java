package com.pucminas.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String codNacional;

    @ElementCollection
    @CollectionTable(name = "TELEFONE", joinColumns = @JoinColumn(name = "id_pessoa"))
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(Integer id, String nome, String email, String codNacional) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.codNacional = codNacional;
    }

}
