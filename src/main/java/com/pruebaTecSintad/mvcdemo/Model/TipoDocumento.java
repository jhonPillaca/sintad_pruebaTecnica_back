package com.pruebaTecSintad.mvcdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name = "tb_tipo_documento")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class TipoDocumento {
    @Id
    @Column(length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_documento;

    @Column(nullable = false, length = 20)
    private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Column(nullable = false)
    private Boolean estado;


}
