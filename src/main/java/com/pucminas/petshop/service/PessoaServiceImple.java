package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.PessoaDto;
import com.pucminas.petshop.entity.Pessoa;
import com.pucminas.petshop.exeptions.IdNotFoundException;
import com.pucminas.petshop.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImple implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PessoaDto getPessoa(Integer id) {

        verificaExistenciaId(id);

        Optional <Pessoa> pessoa = pessoaRepository.findById(id);
        return modelMapper.map(pessoa.get(), PessoaDto.class);
    }

    @Override
    public List<PessoaDto> getPessoas() {

        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().map(pessoa -> modelMapper.map(pessoa, PessoaDto.class)).collect(Collectors.toList());
    }

    @Override
    public PessoaDto criaPessoa(PessoaDto pessoaDto) {
        Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
        pessoaRepository.save(pessoa);
        return modelMapper.map(pessoa, PessoaDto.class);
    }

    @Override
    public PessoaDto atualizaPessoa(Integer id, PessoaDto pessoaDto) {
        verificaExistenciaId(id);
        Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
        pessoa.setId(id);
        pessoaRepository.save(pessoa);
        return modelMapper.map(pessoa, PessoaDto.class);
    }

    @Override
    public void deletaPessoa(Integer id) {
        verificaExistenciaId(id);
        pessoaRepository.deleteById(id);
    }

    private void verificaExistenciaId(Integer id) {
        pessoaRepository.findById(id).orElseThrow(()-> new IdNotFoundException(id));
    }
}
