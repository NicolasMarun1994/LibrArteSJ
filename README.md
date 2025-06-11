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
´´´bash
git clone https://github.com/NicolasMarun1994/LibrArteSJ.git

2. Configurar la base de datos MySQL (por ejemplo, con WAMPP).
3. Modificar las credenciales de base de datos en los archivos application.properties de cada servicio.
4. Levantar primero el servicio eureka-sv.
5. Luego iniciar los servicios author-service, book-service y library-service.

## 🔎 Funcionalidades principales

- Crear autores y libros
- Buscar libro por nombre
- Buscar libros por autor (nombre o apellido)
- Relacionar libros con autores por ID

## 🧪 Pruebas con Postman

Para facilitar las pruebas y exploración de los endpoints de los microservicios, se incluyen colecciones exportadas de Postman en la carpeta `/postman` del repositorio.

### Cómo usar las colecciones

1. Abrir Postman.  
2. Ir a la opción **Importar**.  
3. Seleccionar el archivo `.json` correspondiente a la colección que querés probar dentro de la carpeta `/postman`.  
4. Importar y ejecutar las solicitudes de la colección para probar los distintos endpoints.

### Colecciones disponibles

- `API TEST - AUTHOR SERVICE.postman_collection.json` — Endpoints para gestión de autores.  
- `API TEST - BOOK SERVICE.postman_collection` — Endpoints para gestión de libros.  
- `API TEST - LIBRARY SERVICE.postman_collection.json` — Endpoints para búsquedas centralizadas.

## 🚧 Próximamente se implementará

- Mejorar las validaciones de entrada
- Mejorar el manejo de errores personalizado
- Subida del proyecto a un entorno de prueba en la nube
- Otras mejoras generales

## ☁️ Despliegue futuro

Está previsto subir la aplicación a un servidor en la nube, junto con una base de datos MySQL remota,
para facilitar las pruebas y demostraciones sin necesidad de entorno local.
