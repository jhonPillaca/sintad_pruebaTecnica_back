package com.pruebaTecSintad.mvcdemo.Controller;

import com.pruebaTecSintad.mvcdemo.DTO.TipoDocumentDTO;
import com.pruebaTecSintad.mvcdemo.Model.TipoDocumento;
import com.pruebaTecSintad.mvcdemo.Services.TipoDocmentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="api/sintad/tipo_docment")

public class TipoDocumentController {


    private final TipoDocmentService tipoDocmentService;
    private final ModelMapper modelMapper;

    public TipoDocumentController(TipoDocmentService tipoDocmentService, ModelMapper modelMapper) {
        this.tipoDocmentService = tipoDocmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<TipoDocumentDTO>> listar(){
        List<TipoDocumentDTO> dtoList = tipoDocmentService
                .findAll()
                .stream()
                .map(
                        tipoDocument -> modelMapper.map(tipoDocument, TipoDocumentDTO.class)
                )
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoDocumentDTO> listarPorId(
            @PathVariable(name = "id") Integer id
    ){
        TipoDocumento tipoDocument = tipoDocmentService.findById(id);
        return new ResponseEntity<>(
                modelMapper.map(
                        tipoDocument, TipoDocumentDTO.class
                )
                , HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> registrar(
            @RequestBody TipoDocumentDTO tipoDocumentoRequest
    ){
        TipoDocumento tipoDocument = modelMapper.map(tipoDocumentoRequest, TipoDocumento.class);
        return new ResponseEntity<>(
                tipoDocmentService.save(tipoDocument)
                , HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<TipoDocumento> actualizar(
            @RequestBody TipoDocumentDTO tipoDocumentoRequest
    ){
        TipoDocumento tipoDocment = modelMapper.map(tipoDocumentoRequest, TipoDocumento.class);
        return new ResponseEntity<>(
                tipoDocmentService.update(tipoDocment)
                , HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable("id") Integer id
    ){
        tipoDocmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
