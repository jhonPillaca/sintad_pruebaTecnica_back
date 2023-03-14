package com.pruebaTecSintad.mvcdemo.Services.Implement;

import com.pruebaTecSintad.mvcdemo.Exception.ModelNotFoundException;
import com.pruebaTecSintad.mvcdemo.Model.TipoDocumento;
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
    public TipoDocumento save(TipoDocumento tipoDocumento) {
        this.tipoDocmentRepository.save(tipoDocumento);
        return tipoDocumento;
    }

    @Override
    public TipoDocumento update(TipoDocumento tipoDocumento) {
        Optional<TipoDocumento> optionalTipoDocment = tipoDocmentRepository
                .findById(tipoDocumento.getId_tipo_documento());
        if(!optionalTipoDocment.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %s no existe.", tipoDocumento.getId_tipo_documento().toString())
            );
        }
        tipoDocmentRepository.save(tipoDocumento);
        return tipoDocumento;
    }

    @Override
    public TipoDocumento findById(Integer id) {
        Optional<TipoDocumento> optionalTipoDocumento = tipoDocmentRepository
                .findById(id);
        if(!optionalTipoDocumento.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %d no existe.", id)
            );
        }
        return optionalTipoDocumento.get();
    }

    @Override
    public List<TipoDocumento> findAll() {
        return tipoDocmentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<TipoDocumento> optionalTipoDocumento = tipoDocmentRepository
                .findById(id);
        if(!optionalTipoDocumento.isPresent()){
            throw new ModelNotFoundException(
                    String.format("El registro con el id %d no existe.", id)
            );
        }
        tipoDocmentRepository.deleteById(id);
    }
}
