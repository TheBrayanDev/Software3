package co.edu.matriculasservice.controller;

import co.edu.matriculasservice.api.ApiResponse;
import co.edu.matriculasservice.api.ResponseBuilder;
import co.edu.matriculasservice.dto.MatriculaCreateDTO;
import co.edu.matriculasservice.dto.MatriculaDTO;
import co.edu.matriculasservice.handler.MatriculaHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Matrículas", description = "Gestión de matrículas: registrar, consultar y anular matrículas de estudiantes en cursos")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaHandler handler;

    public MatriculaController(MatriculaHandler handler) {
        this.handler = handler;
    }

    @Operation(
        summary = "Listar todas las matrículas",
        description = "Devuelve la lista completa de matrículas registradas en el sistema, incluyendo su estado (ACTIVA o ANULADA). Requiere autenticación con rol ADMIN o DOCENTE."
    )
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Lista de matrículas obtenida exitosamente"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Token ausente o inválido"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "El usuario no tiene el rol requerido (ADMIN o DOCENTE)")
    })
    @GetMapping
    public ApiResponse<List<MatriculaDTO>> listar() {
        return ResponseBuilder.success("Consulta exitosa", handler.listar());
    }

    @Operation(
        summary = "Buscar matrícula por ID",
        description = "Obtiene la información detallada de una matrícula específica mediante su identificador único. Requiere autenticación con rol ADMIN o DOCENTE."
    )
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Matrícula encontrada"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Matrícula no encontrada con el ID proporcionado"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Token ausente o inválido"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "El usuario no tiene el rol requerido")
    })
    @GetMapping("/{id}")
    public ApiResponse<MatriculaDTO> buscarPorId(
            @Parameter(description = "Identificador único de la matrícula", required = true, example = "1")
            @PathVariable("id") Long id) {
        return ResponseBuilder.success("Consulta exitosa", handler.buscarPorId(id));
    }

    @Operation(
        summary = "Registrar una nueva matrícula",
        description = "Matricula un estudiante en un curso. Antes de registrar, valida que el estudiante exista en estudiantes-service y el curso exista en cursos-service mediante comunicación entre servicios con OpenFeign. También verifica que no exista ya una matrícula activa para el mismo estudiante y curso. La fecha de matrícula se asigna automáticamente al día actual."
    )
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Matrícula registrada exitosamente"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Ya existe una matrícula activa para este estudiante en este curso"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "El estudiante o el curso no existen en sus respectivos servicios"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Token ausente o inválido"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "El usuario no tiene rol ADMIN"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "503", description = "Error de comunicación con estudiantes-service o cursos-service")
    })
    @PostMapping
    public ApiResponse<MatriculaDTO> registrar(@Valid @RequestBody MatriculaCreateDTO dto) {
        return ResponseBuilder.success("Matrícula registrada", handler.registrar(dto));
    }

    @Operation(
        summary = "Anular una matrícula",
        description = "Cambia el estado de una matrícula de ACTIVA a ANULADA. No elimina el registro, solo lo marca como anulado para mantener el historial. Requiere autenticación con rol ADMIN."
    )
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Matrícula anulada exitosamente"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Matrícula no encontrada con el ID proporcionado"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "La matrícula ya se encuentra anulada"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Token ausente o inválido"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "El usuario no tiene rol ADMIN")
    })
    @PutMapping("/{id}/anular")
    public ApiResponse<MatriculaDTO> anular(
            @Parameter(description = "Identificador único de la matrícula a anular", required = true, example = "1")
            @PathVariable("id") Long id) {
        return ResponseBuilder.success("Matrícula anulada", handler.anular(id));
    }
}