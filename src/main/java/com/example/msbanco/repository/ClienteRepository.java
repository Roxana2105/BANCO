package com.example.msbanco.repository;

import com.example.msbanco.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    //Busqueda por DNI
    Optional<ClienteEntity> findByDni(String dni);





}
