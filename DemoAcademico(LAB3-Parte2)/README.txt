## Cómo ejecutar
    cd DemoAcademico(LAB3-Parte2)
    ./mvnw spring-boot:run

## URL Swagger y H2
    Swagger URL: http://localhost:8080/swagger-ui/index.html#/
    H2 URL: http://localhost:8080/h2-console/
        JDBC URL: jdbc:h2:mem:demoacademico
        Usuario: sa
        Contraseña: (debe permanecer vacío)

## Ports creados

    ### EstudianteQueryPort
    Puerto público del módulo estudiantes. Permite a otros módulos consultar estudiantes sin acceder directamente al repositorio directamente.
    - obtenerPorId(Long id): retorna un estudiante por su ID o lanza NotFoundException.

    ### GrupoQueryPort
    Puerto público del módulo grupos. Permite a otros módulos consultar grupos sin acceder directamente al repositorio directamente.
    - obtenerPorId(Long id): retorna un grupo por su ID o lanza NotFoundException.
