# Lab 03 – Ingeniería de Software III

Sistema académico construido con Spring Boot 3.2.5 + Java 21 + H2.

## Cómo ejecutar

```bash
cd PRUEBA_LAB3
./mvnw spring-boot:run
```

## URLs útiles

| Recurso        | URL                                          |
|----------------|----------------------------------------------|
| Swagger UI     | http://localhost:8080/swagger-ui.html        |
| H2 Console     | http://localhost:8080/h2-console             |
| API Base       | http://localhost:8080/api                    |

**H2 JDBC URL:** `jdbc:h2:mem:demoacademico`  
**User:** `sa` / **Password:** *(vacío)*

## Endpoints disponibles

### Estudiantes `/api/estudiantes`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | `/api/estudiantes` | Listar (paginado) |
| GET    | `/api/estudiantes/{id}` | Obtener por ID |
| POST   | `/api/estudiantes` | Crear |
| PUT    | `/api/estudiantes/{id}` | Actualizar |
| DELETE | `/api/estudiantes/{id}` | Eliminar |

### Programas `/api/programas`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | `/api/programas` | Listar (paginado) |
| GET    | `/api/programas/{id}` | Obtener por ID |
| POST   | `/api/programas` | Crear |
| PUT    | `/api/programas/{id}` | Actualizar |
| DELETE | `/api/programas/{id}` | Eliminar |

### Asignaturas `/api/asignaturas`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | `/api/asignaturas` | Listar |
| POST   | `/api/asignaturas` | Crear |
| DELETE | `/api/asignaturas/{id}` | Eliminar |

### Grupos `/api/grupos`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | `/api/grupos` | Listar (paginado) |
| GET    | `/api/grupos/{id}` | Obtener por ID |
| POST   | `/api/grupos` | Crear |
| DELETE | `/api/grupos/{id}` | Eliminar |

### Matrículas `/api/matriculas`
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET    | `/api/matriculas` | Listar (paginado) |
| POST   | `/api/matriculas` | Matricular estudiante en grupo |
| DELETE | `/api/matriculas/{id}` | Cancelar matrícula |

**Reglas de negocio en matrícula:**
- No se puede matricular al mismo estudiante en el mismo grupo dos veces.
- Si el grupo ya alcanzó su cupo máximo, se rechaza la matrícula.

## Estructura de módulos (Parte 2)

```
co.edu.demoacademico
├── common
│   ├── api          – ApiResponse, ResponseBuilder
│   ├── exception    – BusinessException, NotFoundException
│   └── controller   – GlobalExceptionHandler
├── estudiantes      – model, repo, port (EstudianteQueryPort), service, dto, handler, controller
├── programas        – model, repo, service, dto, handler, controller
├── asignaturas      – model, repo, service, dto, handler, controller
├── grupos           – model, repo, port (GrupoQueryPort), service, dto, handler, controller
└── matriculas       – model, repo, service (usa Ports), dto, handler, controller
```

### Patrón de Puertos (Ports)

El módulo `matriculas` **no inyecta** directamente `EstudianteRepository` ni `GrupoRepository`.  
En su lugar utiliza interfaces de puerto:

- `EstudianteQueryPort` → implementada por `EstudianteServiceImpl`
- `GrupoQueryPort` → implementada por `GrupoServiceImpl`

Esto desacopla `matriculas` de los detalles internos de los módulos `estudiantes` y `grupos`.

## Datos de prueba

Al iniciar la aplicación se generan automáticamente (via JavaFaker):
- 100 estudiantes
- 3 programas
- 10 asignaturas
- 20 grupos

Controlado por `application.yaml`:
```yaml
app:
  seed:
    enabled: true
    cantidad: 100
    cantidad-programas: 3
    cantidad-asignaturas: 10
    cantidad-grupos: 20
```
