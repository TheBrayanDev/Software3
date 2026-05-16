package co.edu.matriculasservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Información de una matrícula registrada en el sistema")
public class MatriculaDTO {
    @Schema(description = "Identificador único de la matrícula", example = "1")
    private Long id;
    @Schema(description = "Identificador del estudiante matriculado", example = "1")
    private Long estudianteId;
    @Schema(description = "Identificador del curso en el que está matriculado", example = "1")
    private Long cursoId;
    @Schema(description = "Fecha en que se realizó la matrícula", example = "2026-05-16")
    private LocalDate fechaMatricula;
    @Schema(description = "Estado de la matrícula", example = "ACTIVA", allowableValues = {"ACTIVA", "ANULADA"})
    private String estado;
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Long getEstudianteId() { return estudianteId; } public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public Long getCursoId() { return cursoId; } public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public LocalDate getFechaMatricula() { return fechaMatricula; } public void setFechaMatricula(LocalDate fechaMatricula) { this.fechaMatricula = fechaMatricula; }
    public String getEstado() { return estado; } public void setEstado(String estado) { this.estado = estado; }
}
