# Sistema de Solicitud y Programación de Espacios Físicos

Proyecto desarrollado en Java utilizando programación orientada a objetos, JDBC y MySQL.

## Descripción

Este sistema permite gestionar la solicitud y programación de espacios físicos dentro de una institución educativa.

El proyecto fue desarrollado como evidencia académica para la actividad:

GA7-220501096-AA2-EV01 – Codificación de módulos del software.

---

# Funcionalidades principales

## Módulo de usuarios

Permite:

- Registrar usuarios
- Consultar usuarios
- Actualizar usuarios
- Eliminar usuarios

## Módulo de reservas

Permite:

- Registrar reservas de espacios
- Consultar reservas
- Actualizar reservas
- Eliminar reservas

---

# Tecnologías utilizadas

- Java
- JDBC
- MySQL
- Git
- GitHub
- Visual Studio Code

---

# Estructura del proyecto

```text
src/
│
├── config/
│   └── ConexionBD.java
│
├── dao/
│   ├── UsuarioDao.java
│   └── SolicitudReservaDao.java
│
├── model/
│   ├── Usuario.java
│   └── SolicitudReserva.java
│
└── Main.java
```

---

# Base de datos

Nombre de la base de datos:

```sql
servigestor360db
```

Tablas principales:

- usuario
- solicitud_reserva

---

# Configuración de conexión

Modificar en:

```java
ConexionBD.java
```

Los datos:

```java
private static final String URL =
"jdbc:mysql://localhost:3306/servigestor360db";

private static final String USUARIO = "root";

private static final String CLAVE = "tu_contraseña";
```

---

# Cómo ejecutar el proyecto

1. Crear la base de datos en MySQL.
2. Ejecutar el archivo SQL incluido.
3. Configurar usuario y contraseña en ConexionBD.java.
4. Ejecutar Main.java.
5. Utilizar el menú en consola.

---

# Autor

Duvan Fonseca  
Ficha: 3186707

---

# Repositorio

Proyecto desarrollado con control de versiones usando Git y GitHub.