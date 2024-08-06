package com.sistema_campanha.controllers;

import com.sistema_campanha.dto.UserDTO;
import com.sistema_campanha.entities.Usuario;
import com.sistema_campanha.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    private  UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUsuarioId(@PathVariable(value = "id") Long id){
        Optional<Usuario> usuario = service.findById(id);
        if(usuario.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUser(@RequestBody @Valid UserDTO userDTO){
        var userModel = new Usuario();
        BeanUtils.copyProperties(userDTO, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createdUser(userModel));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id){
        Optional<Usuario> optionalUsuario = service.findById(id);
        if (optionalUsuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário "+optionalUsuario.get().getNome()+" deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid UserDTO userDTO){
        Optional<Usuario> usuario= service.findById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Não encontrado");
        }
        var userModel = usuario.get();
        BeanUtils.copyProperties(userDTO, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(service.createdUser(userModel));
    }




}
