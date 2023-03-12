package com.pruebaTecSintad.mvcdemo.Controller;

import com.pruebaTecSintad.mvcdemo.DTO.TipoContribuyentDTO;
import com.pruebaTecSintad.mvcdemo.Model.TipoContribuyente;
import com.pruebaTecSintad.mvcdemo.Services.TipoContribuyentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="api/sintad/tipo_contribuyent")

public class TipoContribuyentController {

    private final TipoContribuyentService tipoContribuyentService;
    private final ModelMapper modelMapper; // for mapping model => para mapear por modelo

    public TipoContribuyentController(TipoContribuyentService tipoContribuyentService, ModelMapper modelMapper) {
        this.tipoContribuyentService = tipoContribuyentService;
        this.modelMapper = modelMapper;
    }


    @GetMapping
    public ResponseEntity<List<TipoContribuyentDTO>> listar(){
        List<TipoContribuyentDTO> dtoList = tipoContribuyentService
                .findAll()
                .stream()
                .map(
                        tipoContribuyente -> modelMapper.map(tipoContribuyente, TipoContribuyentDTO.class)
                )
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoContribuyentDTO> listarPorId(
            @PathVariable("id") Integer id
    ){
        TipoContribuyente tipoContribuyente = tipoContribuyentService.findById(id);
        return new ResponseEntity<>(
                modelMapper.map(
                        tipoContribuyente, TipoContribuyentDTO.class
                ), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<TipoContribuyente> registrar(
            @RequestBody TipoContribuyentDTO tipoContribuyenteRequest
    ){
        TipoContribuyente tipoContribuyente = modelMapper.map(tipoContribuyenteRequest, TipoContribuyente.class);
        return new ResponseEntity<>(
                tipoContribuyentService.save(tipoContribuyente)
                , HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<TipoContribuyente> actualizar(
            @RequestBody TipoContribuyentDTO tipoContribuyenteRequest
    ){
        TipoContribuyente tipoContribuyente = modelMapper.map(tipoContribuyenteRequest, TipoContribuyente.class);
        return new ResponseEntity<>(
                tipoContribuyentService.update(tipoContribuyente)
                , HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable("id") Integer id
    ){
        tipoContribuyentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
