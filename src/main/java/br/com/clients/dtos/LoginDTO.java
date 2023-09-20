package br.com.clients.dtos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@ApplicationScoped
@Schema(name = "Login", description = "DTO to user login")
public class LoginDTO {
    @Schema(example = "John")
    private String username;
    @Schema(example = "John@example.com")
    private String email;
    @NotBlank(message = "Password is required")
    @Schema(example = "YourStrongPassword@_1")
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
