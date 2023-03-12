package com.pruebaTecSintad.mvcdemo.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
