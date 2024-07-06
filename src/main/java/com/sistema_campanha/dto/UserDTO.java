package com.sistema_campanha.dto;

import com.sistema_campanha.entities.Usuario;
import lombok.*;
import lombok.experimental.Accessors;

import java.beans.ConstructorProperties;
import java.time.LocalDate;
import java.util.List;

@Accessors(chain = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;


}
