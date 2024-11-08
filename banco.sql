-- Database: banco

DROP DATABASE IF EXISTS banco;

CREATE DATABASE banco
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
--drop table Cliente;	
	-- Creación de la tabla Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    cliente_id SERIAL PRIMARY KEY,       -- Identificador único de cada cliente
    nombre VARCHAR(50) NOT NULL,         -- Nombre del cliente, obligatorio
    apellido VARCHAR(50) NOT NULL,       -- Apellido del cliente, obligatorio
    dni VARCHAR(20) NOT NULL UNIQUE,     -- DNI del cliente, obligatorio y único
    email VARCHAR(100),                  -- Email del cliente, validado en formato
    CONSTRAINT email_format CHECK (email ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$') -- Validación de formato de correo
);

-- Creación de la enumeración para el tipo de cuenta
CREATE TYPE TipoCuenta AS ENUM ('AHORROS', 'CORRIENTE');

--drop table CuentaBancaria;
-- Creación de la tabla CuentaBancaria
CREATE TABLE IF NOT EXISTS CuentaBancaria (
    cuenta_id SERIAL PRIMARY KEY,            -- Identificador único de cada cuenta
    numeroCuenta VARCHAR(200) NOT NULL UNIQUE, -- Número de cuenta, único
    saldo DOUBLE PRECISION DEFAULT 0.0,      -- Saldo inicializado en 0.0
    tipoCuenta TipoCuenta NOT NULL,          -- Tipo de cuenta (AHORROS o CORRIENTE)
    cliente_id INT REFERENCES Cliente(cliente_id) -- Relación con la tabla Cliente (múltiples cuentas por cliente)
);


-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (nombre, apellido, dni, email)
VALUES 
('Juan', 'Pérez', '12345678A', 'juan.perez@email.com'),
('Ana', 'Gómez', '87654321B', 'ana.gomez@email.com'),
('Carlos', 'López', '11223344C', 'carlos.lopez@email.com');

--select * from cliente;

-- Insertar datos en la tabla CuentaBancaria
INSERT INTO CuentaBancaria (numeroCuenta, saldo, tipoCuenta, cliente_id)
VALUES
('78901234567890', 1000.50, 'AHORROS', 1),  -- Cuenta de Juan Pérez
('98765432109876', 1500.75, 'CORRIENTE', 2), -- Cuenta de Ana Gómez
('19283746574839', 200.00, 'AHORROS', 3);   -- Cuenta de Carlos López
	
--select * from CuentaBancaria;