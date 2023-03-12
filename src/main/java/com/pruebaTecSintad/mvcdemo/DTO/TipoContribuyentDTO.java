package com.pruebaTecSintad.mvcdemo.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoContribuyentDTO {
    private Integer id_tipo_contribuyente;

    @NotNull
    private String nombre;

    @NotNull
    private Boolean estado;
}
