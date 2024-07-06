package com.sistema_campanha.controllers;

import com.sistema_campanha.dto.UserDTO;
import com.sistema_campanha.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    private  UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return service.getAll();
    }



}
