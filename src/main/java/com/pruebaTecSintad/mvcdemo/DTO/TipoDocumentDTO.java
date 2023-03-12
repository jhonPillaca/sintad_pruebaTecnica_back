package com.pruebaTecSintad.mvcdemo.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoDocumentDTO {

    private Integer id_tipo_documento;

    @NotNull
    private String codigo;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @NotNull
    private Boolean estado;
}
