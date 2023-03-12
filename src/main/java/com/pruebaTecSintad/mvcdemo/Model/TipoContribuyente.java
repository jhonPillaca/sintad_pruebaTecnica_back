package com.pruebaTecSintad.mvcdemo.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_contribuyente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class TipoContribuyente {

    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_contribuyente;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private Boolean estado;


}
