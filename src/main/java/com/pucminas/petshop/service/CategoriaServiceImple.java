package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.CategoriaDto;
import com.pucminas.petshop.entity.Categoria;
import com.pucminas.petshop.exeptions.IdNotFoundException;
import com.pucminas.petshop.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImple implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoriaDto getCategoria(Integer id) {

        verificaExistenciaId(id);

        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return modelMapper.map(categoria.get(), CategoriaDto.class);
    }

    @Override
    public List<CategoriaDto> getCategorias() {

        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(categoria -> modelMapper.map(categoria, CategoriaDto.class)).collect(Collectors.toList());
    }

    @Override
    public CategoriaDto criaCategoria(CategoriaDto categoriaDto) {

        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        categoriaRepository.save(categoria);
        return modelMapper.map(categoria, CategoriaDto.class);
    }

    @Override
    public CategoriaDto atualizaCategoria(Integer id, CategoriaDto categoriaDto) {

        verificaExistenciaId(id);
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        categoria.setId(id);
        categoriaRepository.save(categoria);
        return modelMapper.map(categoria, CategoriaDto.class);
    }

    @Override
    public void deletaCategoria(Integer id) {

        verificaExistenciaId(id);
        categoriaRepository.deleteById(id);
    }

    private void verificaExistenciaId(Integer id) {
        categoriaRepository.findById(id).orElseThrow(()-> new IdNotFoundException(id));
    }
}
