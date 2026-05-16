package co.edu.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Resultado de la validación de un token JWT")
public class TokenValidationResponse {
    @Schema(description = "Indica si el token es válido", example = "true")
    private boolean valid;
    @Schema(description = "Nombre de usuario asociado al token", example = "admin")
    private String username;
    @Schema(description = "Rol del usuario asociado al token", example = "ADMIN")
    private String role;

    public TokenValidationResponse() {
    }

    public TokenValidationResponse(boolean valid, String username, String role) {
        this.valid = valid;
        this.username = username;
        this.role = role;
    }

    public boolean isValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
