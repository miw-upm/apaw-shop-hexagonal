## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Arquitectura y Patrones para Aplicaciones Web (APAW). Arquitectura Hexagonal
> Este proyecto es un apoyo docente de la asignatura y un ejemplo práctico del desarrollo de una aplicación Web siguiendo una Arquitectura por capas

### Tecnologías necesarias
`Java` `Maven` `GitHub` `Spring-boot` 

### :gear: Instalación del proyecto
1. Clonar el repositorio en tu equipo, **mediante consola**:
```sh
> cd <folder path>
> git clone https://github.com/miw-upm/apaw-shop-hexagonal
```
2. Importar el proyecto mediante **IntelliJ IDEA**
   1. **Import Project**, y seleccionar la carpeta del proyecto.
   1. Marcar **Create Project from external model**, elegir **Maven**.
   1. **Next** … **Finish**.   
3. Ejecución.
   1. Desplegar el proyecto localmente: `> mvn clean install`
   1. Arrancar el proyecto: `> mvn spring-boot:run -pl shop-application`

### :book: Más información...
![](docs/hexagonal-architecture.png)   
![](docs/hexagonal-architecture-components.png)   
![](docs/hexagonal-architecture-packages.png)


