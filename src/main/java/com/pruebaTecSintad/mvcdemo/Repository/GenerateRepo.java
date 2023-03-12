package com.pruebaTecSintad.mvcdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenerateRepo <T, ID> extends JpaRepository<T, ID> {
}
