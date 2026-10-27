package com.pragma.backend.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;

public record ClienteRetail(
    @NotNull(message = "El ID no puede ser nulo")
    UUID id,

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    String nombre,

    @NotNull(message = "El apellido no puede ser nulo")
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    String apellido,

    @NotNull(message = "El número de identificación no puede ser nulo")
    @Pattern(regexp = "^\\d{6,12}$", message = "El número de identificación debe ser válido")
    String numeroIdentificacion,

    @NotNull(message = "La dirección no puede ser nula")
    @Size(min = 10, max = 200, message = "La dirección debe tener entre 10 y 200 caracteres")
    String direccion,

    @NotNull(message = "El teléfono no puede ser nulo")
    @Pattern(regexp = "^\\+?[0-9\\s-]{10,15}$", message = "El teléfono debe ser válido")
    String telefono,

    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico debe ser válido")
    String correoElectronico,

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    LocalDate fechaNacimiento,

    @NotNull(message = "La fecha de registro no puede ser nula")
    LocalDate fechaRegistro,

    @Size(max = 500, message = "Las observaciones no pueden exceder los 500 caracteres")
    String observaciones,

    @Pattern(regexp = "^(ACTIVO|INACTIVO|SUSPENDIDO)$", message = "El estado debe ser ACTIVO, INACTIVO o SUSPENDIDO")
    String estado
) {
    public ClienteRetail {
        if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura");
        }
        if (fechaRegistro != null && fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de registro no puede ser futura");
        }
    }

    public ClienteRetail withId(UUID id) {
        return new ClienteRetail(
            id,
            this.nombre,
            this.apellido,
            this.numeroIdentificacion,
            this.direccion,
            this.telefono,
            this.correoElectronico,
            this.fechaNacimiento,
            this.fechaRegistro,
            this.observaciones,
            this.estado
        );
    }
}