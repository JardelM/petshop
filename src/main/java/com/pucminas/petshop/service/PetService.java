package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.CategoriaDto;
import com.pucminas.petshop.dto.PetDto;

import java.util.List;

public interface PetService {

    PetDto getPet(Integer id);

    List<PetDto> getPets();

    PetDto criaPet(PetDto petDto);

    PetDto atualizaPet(Integer id, PetDto petDto);

    void deletaPet(Integer id);
}
