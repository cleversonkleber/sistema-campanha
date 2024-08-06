package com.sistema_campanha.services;

import com.sistema_campanha.dto.UserDTO;
import com.sistema_campanha.entities.Usuario;
import com.sistema_campanha.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id){
            return usuarioRepository.findById(id);

    }


    @GetMapping
    public List<Usuario> findAll() {
       return usuarioRepository.findAll();

    }

    public Usuario createdUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void atualiza(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        usuarioRepository.findById(usuario.getId()).orElseThrow();
        return usuarioRepository.save(usuario);
    }
}
