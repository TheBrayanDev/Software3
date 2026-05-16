package co.edu.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta exitosa de inicio de sesión con token JWT")
public class LoginResponse {
    @Schema(description = "Token JWT generado para autenticación", example = "eyJhbGciOiJIUzI1NiJ9...")
    private String token;
    @Schema(description = "Nombre de usuario autenticado", example = "admin")
    private String username;
    @Schema(description = "Rol asignado al usuario", example = "ADMIN", allowableValues = {"ADMIN", "DOCENTE", "ESTUDIANTE"})
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(String token, String username, String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
