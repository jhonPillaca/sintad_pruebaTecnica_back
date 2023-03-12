package com.pruebaTecSintad.mvcdemo.Exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseException {
    private LocalDateTime dateTime;
    private String mensaje;
    private String detalle;

    public ResponseException(LocalDateTime now, String errorMessage, String description, List<String> errorMessages) {


    }
}
