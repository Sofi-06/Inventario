DROP DATABASE IF EXISTS bd_labfisicamecanica;
CREATE DATABASE IF NOT EXISTS bd_labfisicamecanica;

USE bd_labfisicamecanica;


-- TABLAS


-- Tablas Fuertes (NO DEPENDEN DE OTRA TABLA)


-- Tabla: Persona

CREATE TABLE IF NOT EXISTS personas (
    id_persona INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(85) NOT NULL,
    apellido VARCHAR(36) NOT NULL,
    documento VARCHAR(50) NOT NULL,
    correo VARCHAR(50) NOT NULL,
    telefono VARCHAR(13) NOT NULL,
    usuario VARCHAR(100) NOT NULL,
    contrasenna VARCHAR(200) NOT NULL,
    nivel_acceso VARCHAR(50) NOT NULL,
    CONSTRAINT Persona_pk PRIMARY KEY (id_persona)
);


-- Tabla: Elemento

CREATE TABLE IF NOT EXISTS elementos (
    id_elemento INT AUTO_INCREMENT NOT NULL,
    nom_elemento VARCHAR(100) NOT NULL,
    inv_accesorio VARCHAR(100) NOT NULL,
    referencia VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    CONSTRAINT Elemento_pk PRIMARY KEY (id_elemento)
);


-- Tabla: Inventario de Consumibles

CREATE TABLE IF NOT EXISTS inv_consumibles (
    id_consumibles INT AUTO_INCREMENT NOT NULL,
    nom_elemento VARCHAR(100) NOT NULL,
    referencia VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    foto VARCHAR(300) NOT NULL,
    observaciones VARCHAR(300) NOT NULL,
    num_gabinete INT NOT NULL,
    CONSTRAINT InvConsumibles_pk PRIMARY KEY (id_consumibles)
);


-- Tabla: Inventario de Equipos

CREATE TABLE IF NOT EXISTS inv_equipos (
    id_equipo INT AUTO_INCREMENT NOT NULL,
    nom_equipo VARCHAR(100) NOT NULL,
    inventario VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    serie VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    list_mantenimiento VARCHAR(20) NOT NULL,
    list_req_mantenimiento VARCHAR(20) NOT NULL,
    list_estado VARCHAR(20) NOT NULL,
    CONSTRAINT InvEquipos_pk PRIMARY KEY (id_equipo)
);


-- Tabla: Inventario de Experimientos

CREATE TABLE IF NOT EXISTS inv_experimentos (
    id_experimento INT AUTO_INCREMENT NOT NULL,
    cod_inventario VARCHAR(100) NOT NULL,
    nom_Experimento VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    foto VARCHAR(300) NOT NULL,
    manual TINYINT(1) NOT NULL,
    acta VARCHAR(100) NOT NULL,
    costo INT NOT NULL,
    fecha_compra DATE,
    CONSTRAINT InvExperimentos_pk PRIMARY KEY (id_experimento)
);


-- Tablas Débiles (DEPENDEN DE OTRA TABLA)


-- Tabla: Encabezado

CREATE TABLE IF NOT EXISTS encabezados (
    id_encabezado INT AUTO_INCREMENT NOT NULL,
    edificio VARCHAR(50) NOT NULL,
    laboratorio VARCHAR(50) NOT NULL,
    semestre VARCHAR(50) NOT NULL,
    fecha_actualizacion DATE NOT NULL,
    id_persona INT NOT NULL,
    CONSTRAINT Encabezado_pk PRIMARY KEY (id_encabezado)
);


-- Tabla: Elemento_InvExperimentos

CREATE TABLE IF NOT EXISTS elementos_invExperimentos (
    id_elemento_experimento INT AUTO_INCREMENT NOT NULL,
    id_elemento INT NOT NULL,
    id_experimento INT NOT NULL,
    cantidad_accesorios INT NOT NULL,
    PRIMARY KEY (id_elemento_experimento)
);


-- LLAVES FORÁNEAS


-- Reference: Encabezado_Persona (Tablas: Encabezado)

ALTER TABLE encabezados ADD CONSTRAINT Encabezado_Persona FOREIGN KEY (id_persona) REFERENCES personas (id_persona);


-- Reference: Elemento_InvExperimentos (Tablas: Elemento_InvExperimentos)

ALTER TABLE elementos_invExperimentos
ADD CONSTRAINT Elemento_InvExperimentos_ibfk_1 FOREIGN KEY (id_elemento) REFERENCES elementos (id_elemento) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT Elemento_InvExperimentos_ibfk_2 FOREIGN KEY (id_experimento) REFERENCES inv_experimentos (id_experimento) ON DELETE CASCADE ON UPDATE CASCADE;


-- FIN