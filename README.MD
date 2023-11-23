## Banco App
Aplicacion banco para probar de forma sencilla la implementacion de una api rest con spring boot

### Get started

Docker version 23.0.2 or later.
SpringBoot version 2.7.7
Postgresql version 12.2
RabbitMQ 3

### Aplicacion java con spring boot, 

Estructura del proyecto:
```
.
├── banco_db
│   └── BaseDatos.sql
├── banco_doc
│   └── ...
├── cuentas_app
│   ├── Dockerfile
│   └── ...
├── personas_app
│   ├── Dockerfile
│   └── ...
├── .env
├── docker-compose.yaml
└── README.md
```

El archivo compose define dos aplicaciones `personas_app` y `cuentas_app` cada una de ellas corriendo en el puerto 8080 y 8081 correspondientemente. Adicional, se despliega un servicio de rabbitMQ para establecer las colas de comunicación entre los dos micros y por ultimo se levanta un servicio postgresql en el puerto 5432.

## Deploy with docker compose

```
$ docker compose up -d
```

## Postman 
Dentro de la carpeta de doc se puede encontrar el postman con las apis habilitadas para funcionar.

La mayoría de las funcionalidades están pensadas para correr en el camino feliz.