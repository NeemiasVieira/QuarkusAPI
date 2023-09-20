package br.com.clients.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Create Client", description = "DTO to create a new Client")

public class CreateClientDTO {
    @NotBlank(message = "username is required")
    @Schema(example = "John")
    private String username;
    @NotBlank(message = "email is required")
    @Schema( example = "John")
    @Email(message = "email should be valid")
    private String email;
    @Schema( example = "StrongPasswor2@_")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
            message = "The password should be a strong password"
    )
    @NotBlank(message = "password is required")
    private String password;
    @Schema( example = "32801942432")
    @NotBlank(message = "driverLicenseNumber is required")
    private String driverLicenseNumber;
    @Schema( example = "John Mccain")
    @NotBlank(message = "fullName is required")
    private String fullName;
    @NotBlank(message = "phoneNumber is required")
    @Schema( example = "(13) 99602-0483")
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
