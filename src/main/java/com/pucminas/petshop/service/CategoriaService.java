package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.CategoriaDto;

import java.util.List;

public interface CategoriaService {

    CategoriaDto getCategoria(Integer id);

    List<CategoriaDto> getCategorias();

    CategoriaDto criaCategoria(CategoriaDto categoriaDto);

    CategoriaDto atualizaCategoria(Integer id, CategoriaDto categoriaDto);

    void deletaCategoria(Integer id);
}
