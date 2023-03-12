package com.pruebaTecSintad.mvcdemo.Services.Implement;

import com.pruebaTecSintad.mvcdemo.Exception.ModelNotFoundException;
import com.pruebaTecSintad.mvcdemo.Model.Entidad;
import com.pruebaTecSintad.mvcdemo.Repository.EntitdadRepository;
import com.pruebaTecSintad.mvcdemo.Services.EntidadService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadImplement implements EntidadService {

    private final EntitdadRepository entitdadRepository;
    private final ModelMapper modelMapper;



    public EntidadImplement(EntitdadRepository entitdadRepository, ModelMapper modelMapper) {
        this.entitdadRepository = entitdadRepository;

        this.modelMapper = modelMapper;
    }


    @Override
    public Entidad save(Entidad entidad) {
        if(entidad.getId_entidad() != null){
            Optional<Entidad> optionalEntidad = entitdadRepository.findById(entidad.getId_entidad());
            if(optionalEntidad.isPresent());
            throw new ModelNotFoundException(
                    String.format( "El registro con el id %s ya existe.", entidad.getId_entidad().toString()));
        }
        entitdadRepository.save(entidad);
        return entidad;
    }

    @Override
    public Entidad update(Entidad entidad) {
        Optional<Entidad> optionalEntidad = entitdadRepository.findById(entidad.getId_entidad());
        if(!optionalEntidad.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %s no existe.", entidad.getId_entidad().toString())
            );
        }
        entitdadRepository.save(entidad);
        return entidad;
    }

    @Override
    public Entidad findById(Integer id) {
        Optional<Entidad> optionalEntidad = entitdadRepository.findById(id);
        if(!optionalEntidad.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %d no existe.", id)
            );
        }
        return optionalEntidad.get();
    }

    @Override
    public List<Entidad> findAll() {

        return entitdadRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<Entidad> optionalEntidad = entitdadRepository.findById(id);
        if(!optionalEntidad.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %d no existe.", id)
            );
        }
        entitdadRepository.deleteById(id);
    }
}
