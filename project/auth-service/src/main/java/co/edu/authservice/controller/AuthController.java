package co.edu.authservice.controller;

import co.edu.authservice.dto.LoginRequest;
import co.edu.authservice.dto.LoginResponse;
import co.edu.authservice.dto.TokenValidationResponse;
import co.edu.authservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticación", description = "Endpoints para inicio de sesión y validación de tokens JWT")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
        summary = "Iniciar sesión",
        description = "Autentica un usuario con su nombre de usuario y contraseña. Si las credenciales son correctas, devuelve un token JWT válido por 1 hora que debe usarse en el encabezado Authorization de las peticiones a los demás servicios."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Autenticación exitosa, se devuelve el token JWT"),
        @ApiResponse(responseCode = "401", description = "Credenciales inválidas",
            content = @Content(mediaType = "application/json",
                schema = @Schema(example = "{\"success\":false,\"message\":\"Credenciales inválidas\",\"errorCode\":\"INVALID_CREDENTIALS\",\"status\":401}"))),
        @ApiResponse(responseCode = "400", description = "Cuerpo de la petición inválido, faltan campos requeridos")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @Operation(
        summary = "Validar token JWT",
        description = "Verifica si un token JWT es válido, no ha expirado y pertenece a un usuario activo. Devuelve la validez del token junto con el nombre de usuario y el rol asociado. Requiere enviar el token en el encabezado Authorization con el formato Bearer <token>."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Token validado correctamente"),
        @ApiResponse(responseCode = "401", description = "Token ausente, malformado o inválido")
    })
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/validate")
    public ResponseEntity<TokenValidationResponse> validate(
            @Parameter(description = "Encabezado de autorización con el token JWT", required = true, example = "Bearer eyJhbGciOiJIUzI1NiJ9...")
            @RequestHeader("Authorization") String authorization) {
        return ResponseEntity.ok(authService.validate(authorization));
    }
}