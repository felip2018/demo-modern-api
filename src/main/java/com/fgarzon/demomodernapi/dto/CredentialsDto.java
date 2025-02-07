package com.fgarzon.demomodernapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CredentialsDto {

    @NotNull(message = "El usuario no debe ser nulo")
    @NotBlank(message = "El usuario es obligatorio")
    private String username;

    @NotNull(message = "La contraseña no debe ser nula")
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 5, max = 20, message = "La contraseña debe tener entre 5 y 20 caracteres")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
