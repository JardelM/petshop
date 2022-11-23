package com.pucminas.petshop.controller;

import com.pucminas.petshop.dto.ServicoDto;
import com.pucminas.petshop.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService service;

    @GetMapping("/{id}")
    public ServicoDto buscaId (@PathVariable Integer id){
        return service.getServico(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoDto createServico (@RequestBody @Valid ServicoDto servicoDto){
        return service.criaServico(servicoDto);
    }

    @PutMapping("/{id}")
    public ServicoDto updateServico (@PathVariable Integer id, @RequestBody @Valid ServicoDto servicoDto){
        return service.atualizaServico(id, servicoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteServico (@PathVariable Integer id){
        service.deletaServico(id);
    }

}
