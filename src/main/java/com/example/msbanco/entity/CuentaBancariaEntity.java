package com.example.msbanco.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CuentaBancaria")
@Data
@NoArgsConstructor
public class CuentaBancariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    @Column(name = "cuenta_id") // Nombre de la columna en la base de datos
    private Long cuentaId;

    @Column(name = "numero_cuenta", nullable = false, unique = true)
    @NotNull(message = "El número de cuenta es obligatorio.")
    private String numeroCuenta;

    @Column(name = "saldo", nullable = false)
    private Double saldo = 0.0; // Inicialización de saldo a 0.0

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false)
    private TipoCuenta tipoCuenta; // Campo de tipo Enum (AHORROS o CORRIENTE)

}
