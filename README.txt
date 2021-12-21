# Evaluacion JAVA Microservicio Usuarios.

Ejercicio de Prueba de API RESTful de creacion de usuarios.

Autor: Diego Aliaga Díaz - Ing. de Software (SEnTRA).

## Starters Utilizados.

* H2 Database
* Spring web
* Spring Boot DevTools
* Lombok
* Spring Data JPA

## Ejecucion

Las pruebas y ejecuciones de este proyecto han sido realizadas mediante Postman, para probar las funcionalidades utilizar las siguientes url's

* POST: localhost:8080/usuarios

- Agregar un nuevo Usuario.
- en Body de la peticion copiar:
{
    "nombre": "",
    "email": "",
    "password": "",
    "telefonos": [
        {
            "numero": ,
            "codCiudad": ,
            "codPais" : 
        }
    ]
}

- Los valores nombre, email y password van como String.
- Los valores dentro del arreglo de telefonos son enteros.
- Enviar como JSON.

* GET: localhost:8080/usuarios

- Obtener usuarios registrados.

* GET: localhost:8080/usuarios/{UUID de usuario, obtenida con llamado POST o GET anteriores}

- Obtener un usuario con su id.

* DELETE: localhost:8080/usuario/{UUID de usuario, obtenida con llamado POST o GET anteriores}

- Cambiar estado de activo a inactivo.

* PUT: localhost:8080/usuario --> NO FUNCIONAL

- En body de la peticion agregar:

    {
        "id": "",
        "nombre": "",
        "email": "",
        "password": "",
        "telefonos": [
            {
                "numero": ,
                "codCiudad": ,
                "codPais": 
            },
            {
                "numero": ,
                "codCiudad": ,
                "codPais": 
            }
        ],
        "created": "2021-12-21T21:01:44.176+00:00",
        "modified": "2021-12-21T21:01:44.176+00:00",
        "lastLogin": "2021-12-21T21:01:44.176+00:00",
        "token": "",
        "active": 
    }

