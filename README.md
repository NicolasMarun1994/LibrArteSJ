# LibrArteSJ

Proyecto backend desarrollado en **Java** con **Spring Boot**, basado en arquitectura de **microservicios**, para gestionar una librería de libros usados. Permite crear libros, autores, y realizar búsquedas centralizadas entre servicios.

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Cloud (Eureka, OpenFeign, Load Balancer)
- Spring Data JPA
- MySQL (via WAMPP local)
- Maven
- Postman (para pruebas)

## 📦 Microservicios

- book-service: gestión de libros.
- author-service: gestión de autores.
- library-service: servicio de búsqueda.
- eureka-sv: servidor de descubrimiento de servicios (Eureka).

## ▶️ Cómo ejecutar el proyecto localmente

1. Clonar el repositorio:	
	git clone https://github.com/NicolasMarun1994/LibrArteSJ.git
	
2. Configurar la base de datos MySQL (Yo use WAMPP).   
3. Modificar las credenciales de base de datos en los archivos `application.properties` de cada servicio.
4. Crear previamente las tablas necesarias para cada microservicio en la base de datos. Esto puede hacerse:
	- De forma manual: 
		> `author_service` para el microservicio de autores  
		> `book_service` para el microservicio de libros
		
5. Levantar primero el servicio `eureka-sv`.
6. Luego iniciar los servicios `author-service`, `book-service` y `library-service`.

## 🔎 Funcionalidades principales

- Crear autores y libros
- Buscar libro por nombre
- Buscar libros por autor (nombre o apellido)
- Relacionar libros con autores por ID

## 🐳 Dockerización local

El sistema fue dockerizado y probado exitosamente en entorno local, utilizando contenedores para cada microservicio y la base de datos MySQL. 
Esto permite levantar toda la aplicación de forma automatizada con Docker Compose.
Por el momento, las imágenes y archivos necesarios no se encuentran en el repositorio, ya que el proyecto aún no ha sido desplegado en un entorno con soporte para contenedores. Sin embargo, está preparado para ello, y se incluirán cuando se realice el despliegue del mismo.

## 🧪 Pruebas con Postman

El sistema ha sido **totalmente probado con Postman**. Todas las colecciones se incluyen en la carpeta `/postman` del repositorio, organizadas por servicio.

### Cómo usar las colecciones

1. Abrir Postman.  
2. Ir a la opción **Importar**.  
3. Seleccionar el archivo `.json` correspondiente.  
4. Ejecutar las solicitudes de la colección para probar los distintos endpoints.

### Colecciones disponibles

- 📘 `API TEST - AUTHOR SERVICE` — Endpoints para gestión de autores.  
- 📗 `API TEST - BOOK SERVICE` — Endpoints para gestión de libros.  
- 📙 `API TEST - LIBRARY SERVICE` — Endpoints para búsquedas centralizadas.

## 🚧 Próximamente se implementará

- Mejorar las validaciones de entrada (hacerlas más robustas)
- Mejorar el manejo de errores usando el manejo personalizado
- Subida del proyecto a un entorno de prueba en la nube
- Otras mejoras generales

## ☁️ Despliegue futuro

Está previsto subir la aplicación a un servidor en la nube, junto con una base de datos MySQL remota.
Por el momento, el sistema puede ejecutarse localmente y está 100% funcional y probado.
