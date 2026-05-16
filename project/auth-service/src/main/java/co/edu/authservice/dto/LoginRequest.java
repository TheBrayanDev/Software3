package co.edu.authservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Credenciales de inicio de sesión")
public class LoginRequest {
    @NotBlank
    @Schema(description = "Nombre de usuario del usuario registrado", example = "admin")
    private String username;
    @NotBlank
    @Schema(description = "Contraseña del usuario", example = "admin123")
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
