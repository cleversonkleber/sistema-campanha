package com.sistema_campanha.services;

import com.sistema_campanha.dto.UserDTO;
import com.sistema_campanha.entities.Usuario;
import com.sistema_campanha.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        Usuario usuario = usuarioRepository.findById(id).get();
        var dto = new UserDTO();
        BeanUtils.copyProperties(usuario,dto);
        return dto;

    }


    @GetMapping
    public List<UserDTO> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> {
            UserDTO dto =  new UserDTO();
            BeanUtils.copyProperties(usuario,dto);
            return dto;
        }).toList();

    }

    public Usuario createdUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
