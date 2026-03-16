DROP DATABASE IF EXISTS ProyectoMVC;
CREATE DATABASE ProyectoMVC;
USE ProyectoMVC;

CREATE TABLE IF NOT EXISTS AUTOR(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    telefono VARCHAR(15)
);
CREATE TABLE IF NOT EXISTS LIBRO(
    id INT PRIMARY KEY AUTO_INCREMENT,     -- Identificador único del libro
    titulo VARCHAR(100) NOT NULL,          -- Título del libro
    isbn VARCHAR(13),                      -- Código ISBN del libro
    anio INT,                              -- Año de publicación
    descripcion VARCHAR(200),              -- Descripción corta del libro
    url TEXT,                              -- URL o imagen (permite mucho más texto)
    id_autor INT,
    
    FOREIGN KEY (id_autor) 
    REFERENCES AUTOR(id)
);
CREATE TABLE IF NOT EXISTS USUARIO(
	codigo INT AUTO_INCREMENT PRIMARY KEY,
	telefono VARCHAR(15),
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    sexo CHAR(1) CHECK (sexo IN ('M','F')),
    fecha_Nacimiento DATE
);
CREATE TABLE IF NOT EXISTS PRESTADO(
	id_libro INT,
    cod_usuario INT,
    PRIMARY KEY(id_libro, cod_usuario),
    FOREIGN KEY (id_libro)
    REFERENCES LIBRO(id),
    FOREIGN KEY (cod_usuario)
    REFERENCES USUARIO(codigo)
);
INSERT INTO AUTOR(id, nombre) VALUES (1, 'Gabriel García Márquez');

INSERT INTO LIBRO(titulo, isbn, anio, descripcion, id_autor) 
VALUES ('Cien Años de Soledad', 123456789, 1967, 'Novela clásica', 1);