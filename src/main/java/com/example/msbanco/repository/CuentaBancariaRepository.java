package com.example.msbanco.repository;

import com.example.msbanco.entity.ClienteEntity;
import com.example.msbanco.entity.CuentaBancariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancariaEntity, Long> {

    //Busqueda por Cuenta Corriente
    Optional<CuentaBancariaEntity> findByNumeroCuenta(String numCuenta);

}
