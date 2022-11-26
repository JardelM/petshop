package com.pucminas.petshop.controller;

import com.pucminas.petshop.dto.PetDto;
import com.pucminas.petshop.dto.PetDto;
import com.pucminas.petshop.service.PetService;
import com.pucminas.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/{id}")
    public PetDto buscaPet (@PathVariable Integer id){
        return petService.getPet(id);
    }

    @GetMapping()
    public List<PetDto> listaPet (){
        return petService.getPets();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetDto createPet (@RequestBody @Valid PetDto petDto){
        return petService.criaPet(petDto);
    }

    @PutMapping("/{id}")
    public PetDto updatePet (@PathVariable Integer id, @RequestBody @Valid PetDto petDto){
        return petService.atualizaPet(id, petDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePet (@PathVariable Integer id){
        petService.deletaPet(id);
    }
}
