package com.pruebaTecSintad.mvcdemo.Controller;

import com.pruebaTecSintad.mvcdemo.DTO.EntidadDTO;
import com.pruebaTecSintad.mvcdemo.Model.Entidad;
import com.pruebaTecSintad.mvcdemo.Services.EntidadService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping(value = "api/sintad/entidad")
@Slf4j
public class EntidadController {

    private final EntidadService entidadService;
    private final ModelMapper modelMapper;

    public EntidadController(EntidadService entidadService, ModelMapper modelMapper) {
        this.entidadService = entidadService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<EntidadDTO> list = entidadService
                    .findAll()
                    .stream()
                    .map(
                            entidad -> modelMapper.map(entidad, EntidadDTO.class)
                    )
                    .collect(Collectors.toList());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.error("Error al listar entidades", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar entidades");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        try {
            Entidad entidad = entidadService.findById(id);
            return ResponseEntity.ok(modelMapper.map(entidad, EntidadDTO.class));
        } catch (Exception e) {
            log.error("Error al obtener entidad con id: {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener entidad");
        }
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody EntidadDTO entidadDTO) {
        try {
            Entidad entidadMapper = modelMapper.map(entidadDTO, Entidad.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(entidadService.save(entidadMapper));
        } catch (Exception e) {
            log.error("Error al registrar entidad", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar entidad");
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody EntidadDTO entidadDTO) {
        try {
            Entidad entidadMapper = modelMapper.map(entidadDTO, Entidad.class);
            return ResponseEntity.ok(entidadService.update(entidadMapper));
        } catch (Exception e) {
            log.error("Entidad no encontrada con id: {}", entidadDTO.getId_entidad());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        try {
            entidadService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Entidad no encontrada con id: {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
