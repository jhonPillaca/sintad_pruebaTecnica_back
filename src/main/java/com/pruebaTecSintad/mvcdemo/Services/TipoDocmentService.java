package com.pruebaTecSintad.mvcdemo.Services;

import com.pruebaTecSintad.mvcdemo.Model.TipoDocumento;

public interface TipoDocmentService extends Crud<TipoDocumento, Integer>{
    abstract TipoDocumento update(TipoDocumento tipoDocumento);
}
