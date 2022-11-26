package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.ServicoDto;
import com.pucminas.petshop.entity.Servico;
import com.pucminas.petshop.exeptions.IdNotFoundException;
import com.pucminas.petshop.repository.ServicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoServiceImple implements ServicoService {

    @Autowired
    ServicoRepository servicoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServicoDto getServico(Integer id) {
        verificaExistenciaId(id);
        Optional<Servico> categoria = servicoRepository.findById(id);
        return modelMapper.map(categoria.get(), ServicoDto.class);
    }
    @Override
    public ServicoDto criaServico(ServicoDto servicoDto) {
        Servico servico = modelMapper.map(servicoDto, Servico.class);
        servicoRepository.save(servico);
        return modelMapper.map(servico, ServicoDto.class);
    }
    @Override
    public ServicoDto atualizaServico(Integer id, ServicoDto servicoDto) {
        verificaExistenciaId(id);
        Servico servico = modelMapper.map(servicoDto, Servico.class);
        servico.setId(id);
        servicoRepository.save(servico);
        return modelMapper.map(servico, ServicoDto.class);
    }
    @Override
    public void deletaServico(Integer id) {
        verificaExistenciaId(id);
        servicoRepository.deleteById(id);
    }
    private void verificaExistenciaId(Integer id) {
        servicoRepository.findById(id).orElseThrow(()-> new IdNotFoundException(id));
    }
}
