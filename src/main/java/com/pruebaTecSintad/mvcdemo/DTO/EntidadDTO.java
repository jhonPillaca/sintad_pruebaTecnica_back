package com.pruebaTecSintad.mvcdemo.DTO;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntidadDTO {

    private Integer id_entidad;

    @NotNull
    private TipoDocumentDTO tipoDocumento;

    @NotNull
    private String nro_documento;

    @NotNull
    private String razon_social;

    @NotNull
    private String nombre_comercial;

    @NotNull
    private TipoContribuyentDTO tipoContribuyente;

    @NotNull
    private String direccion;

    @NotNull
    private String telefono;

    @NotNull
    private Boolean estado;

}
