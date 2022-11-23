package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.PessoaDto;

import java.util.List;

public interface PessoaService {

    PessoaDto getPessoa(Integer id);

    List<PessoaDto> getPessoas();

    PessoaDto criaPessoa(PessoaDto pessoaDto);

    PessoaDto atualizaPessoa(Integer id, PessoaDto pessoaDto);

    void deletaPessoa(Integer id);
}
