package com.pruebaTecSintad.mvcdemo.Services.Implement;

import com.pruebaTecSintad.mvcdemo.Exception.ModelNotFoundException;
import com.pruebaTecSintad.mvcdemo.Model.TipoDocment;
import com.pruebaTecSintad.mvcdemo.Repository.TipoDocmentRepository;
import com.pruebaTecSintad.mvcdemo.Services.TipoDocmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentImplement implements TipoDocmentService {

    private final TipoDocmentRepository tipoDocmentRepository;

    public TipoDocumentImplement(TipoDocmentRepository tipoDocmentRepository) {
        this.tipoDocmentRepository = tipoDocmentRepository;
    }

    @Override
    public TipoDocment save(TipoDocment tipoDocment) {

        return tipoDocment;
    }

    @Override
    public TipoDocment update(TipoDocment tipoDocment) {
        Optional<TipoDocment> optionalTipoDocment = tipoDocmentRepository
                .findById(tipoDocment.getId_tipo_documento());
        if(!optionalTipoDocment.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %s no existe.", tipoDocment.getId_tipo_documento().toString())
            );
        }
        tipoDocmentRepository.save(tipoDocment);
        return tipoDocment;
    }

    @Override
    public TipoDocment findById(Integer id) {
        Optional<TipoDocment> optionalTipoDocumento = tipoDocmentRepository
                .findById(id);
        if(!optionalTipoDocumento.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %d no existe.", id)
            );
        }
        return optionalTipoDocumento.get();
    }

    @Override
    public List<TipoDocment> findAll() {
        return tipoDocmentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<TipoDocment> optionalTipoDocumento = tipoDocmentRepository
                .findById(id);
        if(!optionalTipoDocumento.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %d no existe.", id)
            );
        }
        tipoDocmentRepository.deleteById(id);
    }
}
