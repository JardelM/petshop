package com.pucminas.petshop.controller;

import com.pucminas.petshop.dto.PessoaDto;
import com.pucminas.petshop.entity.Pessoa;
import com.pucminas.petshop.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public PessoaDto buscaPessoa (@PathVariable Integer id){
        return pessoaService.getPessoa(id);
    }

    @GetMapping
    public List<PessoaDto> buscaTodos(){
        return pessoaService.getPessoas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDto createPessoa (@RequestBody @Valid PessoaDto pessoaDto){
        return pessoaService.criaPessoa(pessoaDto);
    }

    @PutMapping("/{id}")
    public PessoaDto updatePessoa (@PathVariable Integer id, @RequestBody @Valid PessoaDto pessoaDto){
        return pessoaService.atualizaPessoa(id, pessoaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePessoa (@PathVariable Integer id){
        pessoaService.deletaPessoa(id);
    }



}
