package com.pruebaTecSintad.mvcdemo.Repository;

import com.pruebaTecSintad.mvcdemo.Model.Entidad;
import com.pruebaTecSintad.mvcdemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends GenerateRepo <User, Integer> {
    User findOneByUsername(String username);

}
