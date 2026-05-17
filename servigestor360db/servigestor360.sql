-- =========================================
-- CREAR BASE DE DATOS
-- =========================================

CREATE DATABASE IF NOT EXISTS servigestor360db;

USE servigestor360db;

-- =========================================
-- TABLA USUARIO
-- =========================================

CREATE TABLE usuario (

    idUsuario INT PRIMARY KEY AUTO_INCREMENT,

    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,

    tipoDocumento VARCHAR(50) NOT NULL,
    numeroDocumento VARCHAR(50) NOT NULL UNIQUE,

    telefono VARCHAR(30),
    correoElectronico VARCHAR(100) UNIQUE,

    rol VARCHAR(50),

    activo BOOLEAN DEFAULT TRUE
);

-- =========================================
-- TABLA RESERVA
-- =========================================

CREATE TABLE solicitud_reserva (

    idReserva INT PRIMARY KEY AUTO_INCREMENT,

    idUsuario INT NOT NULL,

    fechaReserva DATE NOT NULL,
    horaReserva TIME NOT NULL,

    motivo VARCHAR(255) NOT NULL,

    espacio VARCHAR(50) NOT NULL,

    estado VARCHAR(50) DEFAULT 'Pendiente',

    observaciones VARCHAR(255),

    FOREIGN KEY (idUsuario)
        REFERENCES usuario(idUsuario)
        ON DELETE CASCADE
);

-- =========================================
-- DATOS DE PRUEBA
-- =========================================

INSERT INTO usuario (
    nombres,
    apellidos,
    tipoDocumento,
    numeroDocumento,
    telefono,
    correoElectronico,
    rol,
    activo
)
VALUES
(
    'Duvan',
    'Fonseca',
    'CC',
    '123456789',
    '3000000000',
    'duvan@gmail.com',
    'Estudiante',
    TRUE
);

INSERT INTO solicitud_reserva (
    idUsuario,
    fechaReserva,
    horaReserva,
    motivo,
    espacio,
    estado,
    observaciones
)
VALUES
(
    1,
    '2025-08-15',
    '10:00:00',
    'Proyecto académico',
    'Sala A1',
    'Aprobada',
    'Reserva inicial'
);