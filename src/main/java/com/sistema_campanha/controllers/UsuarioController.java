package com.sistema_campanha.controllers;

import com.sistema_campanha.dto.UserDTO;
import com.sistema_campanha.entities.Usuario;
import com.sistema_campanha.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/usuario")
    public Usuario saveUser(@RequestBody Usuario usuario){
        return service.createdUser(usuario);
    }

    @PostMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping(value = "/update")
    public Usuario update(@RequestBody Usuario usuario){
        return service.update(usuario);
    }




}
