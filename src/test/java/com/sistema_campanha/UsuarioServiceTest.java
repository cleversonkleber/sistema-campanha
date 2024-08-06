package com.sistema_campanha;


import com.sistema_campanha.repositories.UsuarioRepository;
import com.sistema_campanha.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("UsuarioServiceTest")
public class UsuarioServiceTest  extends ApplicationConfigTest{

    @MockBean
    UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService service;

    @Test
    public void usuariosService(){
        System.out.println("OLa");
    }


}
