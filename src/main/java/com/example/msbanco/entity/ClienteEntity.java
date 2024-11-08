package com.example.msbanco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Column(nullable = false, length = 40)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio.")
    @Column(nullable = false, length = 40)
    private String apellido;

    @NotBlank(message = "El DNI es obligatorio.")
    @Column(nullable = false, length = 15)
    @Size(min = 8, max = 20, message = "El DNI debe tener entre 8 y 20 caracteres.")
    private String dni;

    @Email(message = "El formato del correo es inválido.")
    @Column(nullable = false, length = 40)
    private String email;
}
