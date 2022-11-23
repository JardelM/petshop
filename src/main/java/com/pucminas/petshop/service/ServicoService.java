package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.ServicoDto;

public interface ServicoService {

    ServicoDto getServico(Integer id);

    ServicoDto criaServico(ServicoDto servicoDto);

    ServicoDto atualizaServico(Integer id, ServicoDto servicoDto);

    void deletaServico(Integer id);
}
