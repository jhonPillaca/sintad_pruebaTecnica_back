package com.pruebaTecSintad.mvcdemo.Services;

import com.pruebaTecSintad.mvcdemo.Model.Entidad;

public interface EntidadService extends Crud<Entidad, Integer> {
    Entidad update(Entidad entidad);
}
