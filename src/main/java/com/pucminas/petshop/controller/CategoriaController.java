package com.pucminas.petshop.controller;

import com.pucminas.petshop.dto.CategoriaDto;
import com.pucminas.petshop.dto.PessoaDto;
import com.pucminas.petshop.entity.Categoria;
import com.pucminas.petshop.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public CategoriaDto buscaCategoria (@PathVariable Integer id){
        return categoriaService.getCategoria(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDto createCategoria (@RequestBody @Valid CategoriaDto categoriaDto){
        return categoriaService.criaCategoria(categoriaDto);
    }

    @PutMapping("/{id}")
    public CategoriaDto updateCategoria (@PathVariable Integer id, @RequestBody @Valid CategoriaDto categoriaDto){
        return categoriaService.atualizaCategoria(id, categoriaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategoria (@PathVariable Integer id){
        categoriaService.deletaCategoria(id);
    }
}
