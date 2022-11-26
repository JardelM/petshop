package com.pucminas.petshop.service;

import com.pucminas.petshop.dto.PetDto;
import com.pucminas.petshop.entity.Pet;
import com.pucminas.petshop.exeptions.IdNotFoundException;
import com.pucminas.petshop.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImple implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PetDto getPet(Integer id) {

        verificaExistenciaId(id);

        Optional<Pet> pet = petRepository.findById(id);
        return modelMapper.map(pet.get(), PetDto.class);
    }

    @Override
    public List<PetDto> getPets() {

        List<Pet> pets = petRepository.findAll();
        return pets.stream().map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public PetDto criaPet(PetDto petDto) {

        Pet pet = modelMapper.map(petDto, Pet.class);
        petRepository.save(pet);
        return modelMapper.map(pet, PetDto.class);
    }

    @Override
    public PetDto atualizaPet(Integer id, PetDto petDto) {

        verificaExistenciaId(id);
        Pet pet = modelMapper.map(petDto, Pet.class);
        pet.setId(id);
        petRepository.save(pet);
        return modelMapper.map(pet, PetDto.class);
    }

    @Override
    public void deletaPet(Integer id) {

        verificaExistenciaId(id);
        petRepository.deleteById(id);
    }

    private void verificaExistenciaId(Integer id) {
        petRepository.findById(id).orElseThrow(()-> new IdNotFoundException(id));
    }
}
