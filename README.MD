# Gestor de reservas internas

_Aplicacion FullStack BETA con una interfaz web realizar gestion interna de Empleados, habitaciones y reservas por parte de empleados autorizados de un hotel._
_ basada en servlets para usando la especificacion JPA para persistencia de datos y el patron de diseño MVC_
## Comenzando 🚀

_Clonar el proyecto._

``` git clone https://github.com/pdegaudenci/reservasWeb-JavaEE.git ```


### Pre-requisitos 📋

_Debe tener instalado y configurado dos servicios:_

* Servidor de BBDD MySql
* Servidor web Apache Tomcat

### Dependencias

_El proyecto tiene fue desarrollado con las siguientes librerias externas:_
```
	Java Persistence API
	mysql-connector-java-5.1.15-bin
	javaee-endorsed-api-7.0
	javax.persistence
	javax.servlet-3.0
	jcalendar-1.4
```

### Instalación 🔧

_Una serie de ejemplos paso a paso que te dice lo que debes ejecutar para tener un entorno de desarrollo ejecutandose_

_Dí cómo será ese paso_

```
Da un ejemplo
```



### Analisis funcional ⌨️

_En relacion al hotel_

Cada habitación cuenta con un número identificatorio, el piso donde se encuentra, un nombre según su
temática, el tipo (single, doble, triple o múltiple) y el precio por noche.
Para poder realizar una reserva de una habitación es necesario contar con la fecha de check-in (ingreso al
hotel) y fecha de check-out (egreso del hotel). Antes de confirmar una reserva, el sistema  verifica
que la habitación solicitada no esté reservada en el período de tiempo que se haya elegido. 
A partir de la cantidad de días que se hospede la persona y del tipo de habitación que haya elegido, el
sistema devuelve el monto total de la estadía; al mismo tiempo, verifica que la cantidad
de personas que se hospedarán no supere la cantidad establecida por el tipo de habitación; estas
cantidades se detallan a continuación:

![Opera Instantánea_2023-01-08_230020_cursos polotic misiones gob ar](https://user-images.githubusercontent.com/73450522/211221177-e597e5a6-65ab-4b8b-81a3-3778b1b25c2b.png)

_En relación a los huespedes:_
Los datos que se registran de cada huesped son: 
dni, nombre, apellido, fecha de nacimiento, dirección y profesión. Por cuestiones de privacidad del hotel,
no se registrarán los datos de los acompañantes.

_En relacion a los empleados:_

El sistema está pensado para ser utilizado únicamente por los EMPLEADOS del hotel, por lo que la interfaz
gráfica y la utilización está desarrollada de esta manera (no como un sistema de reservas online).
Para la administración de los empleados, cada uno de ellos posee un usuario y contraseña que le
permitirá ingresar al sistema; para ello, cada uno de ellos deberá de estar registrado en el sistema con sus
correspondientes datos personales (dni, nombre, apellido, fecha de nacimiento, dirección y cargo).

_Funcionalidades generales de la aplicacion:_

* Todas las reservas realizadas en un determinado día.
* Todos los huéspedes registrados en el sistema.
* Lista de las reservas realizadas por un determinado empleado.
* Listas de todas las reservas realizadas por un determinado huésped en un período desde/hasta.

## Despliegue 📦

_Agrega notas adicionales sobre como hacer deploy_

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* Herramienta XAMPP
* Sistema Gestor de base de datos relacionales MySQL : Gestion de operaciones de datos de negocio
* Servidor web TOMCAT : Despliegue de la aplicacion a nivel local
* Java EE : Lenguaje utilizado del lado del servidor para gestionar las peticiones recibidas del lado del cliente
* Servlets: Para construir la logica de los controladores del servidor que recibirán las peticiones HTTP del cliente a traves de HttpServletRequest y  HttpServletResponse
* JSP : Para ejecutar codigo Java del lado del Cliente
* HTML && CSS : Estructura,contenido y estilos de la interfaz web 


## Licencia 📄

Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo [LICENSE.md](LICENSE.md) para detalles



