package com.pruebaTecSintad.mvcdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {

    @Id
    private Integer id_usuario;
    private String username;
    private String password;
    private Boolean enabled;
}
