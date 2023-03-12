package com.pruebaTecSintad.mvcdemo.Services.Implement;

import com.pruebaTecSintad.mvcdemo.Exception.ModelNotFoundException;
import com.pruebaTecSintad.mvcdemo.Model.TipoContribuyente;
import com.pruebaTecSintad.mvcdemo.Repository.TipoContribuyentRepository;
import com.pruebaTecSintad.mvcdemo.Services.TipoContribuyentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContribuyentImplement implements TipoContribuyentService {

    private final TipoContribuyentRepository tipoContribuyentRepository;

    public TipoContribuyentImplement(TipoContribuyentRepository tipoContribuyentRepository) {
        this.tipoContribuyentRepository = tipoContribuyentRepository;
    }


    @Override
    public TipoContribuyente save(TipoContribuyente tipoContribuyente) {
        if(tipoContribuyente.getId_tipo_contribuyente() != null){
            Optional<TipoContribuyente> optionalTipoContribuyente = tipoContribuyentRepository
                    .findById(tipoContribuyente.getId_tipo_contribuyente());
            if(optionalTipoContribuyente.isPresent())
                throw new ModelNotFoundException(
                        String.format("El registro con el id %s ya existe.", tipoContribuyente.getId_tipo_contribuyente().toString())
                );

        }
        tipoContribuyentRepository.save(tipoContribuyente);
        return tipoContribuyente;
    }

    @Override
    public TipoContribuyente update(TipoContribuyente tipoContribuyente) {
        Optional<TipoContribuyente> optionalTipoContribuyente = tipoContribuyentRepository
                .findById(tipoContribuyente.getId_tipo_contribuyente());
        if(!optionalTipoContribuyente.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %s no existe.", tipoContribuyente.getId_tipo_contribuyente().toString())
            );
        }
        tipoContribuyentRepository.save(tipoContribuyente);
        return tipoContribuyente;
    }

    @Override
    public TipoContribuyente findById(Integer id) {
        Optional<TipoContribuyente> optionalTipoContribuyente = tipoContribuyentRepository
                .findById(id);
        if(!optionalTipoContribuyente.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %s no existe.", id)
            );
        }
        return optionalTipoContribuyente.get();
    }

    @Override
    public List<TipoContribuyente> findAll() {
        return tipoContribuyentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<TipoContribuyente> optionalTipoContribuyente = tipoContribuyentRepository
                .findById(id);
        if(!optionalTipoContribuyente.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %s no existe.", id)
            );
        }
        tipoContribuyentRepository.deleteById(id);
    }
}
