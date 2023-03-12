package com.pruebaTecSintad.mvcdemo.Services;

import com.pruebaTecSintad.mvcdemo.Model.Entidad;
import com.pruebaTecSintad.mvcdemo.Model.TipoDocment;

public interface TipoDocmentService extends Crud<TipoDocment, Integer>{
    abstract TipoDocment update(TipoDocment tipoDocment);
}
