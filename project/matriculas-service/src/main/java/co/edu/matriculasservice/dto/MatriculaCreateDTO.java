package co.edu.matriculasservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Datos para registrar una nueva matrícula")
public class MatriculaCreateDTO {
    @NotNull
    @Schema(description = "Identificador del estudiante a matricular, debe existir en estudiantes-service", example = "1")
    private Long estudianteId;
    @NotNull
    @Schema(description = "Identificador del curso en el que se matricula, debe existir en cursos-service", example = "1")
    private Long cursoId;
    public Long getEstudianteId() { return estudianteId; } public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public Long getCursoId() { return cursoId; } public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
}
