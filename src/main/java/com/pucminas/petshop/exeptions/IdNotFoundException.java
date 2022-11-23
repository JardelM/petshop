package com.pucminas.petshop.exeptions;

public class IdNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public IdNotFoundException(Integer id) {
        super(String.format("Id %s inexistente", id));
    }
}
