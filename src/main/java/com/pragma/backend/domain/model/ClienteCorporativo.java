package com.pragma.backend.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ClienteCorporativo(
    @NotNull(message = "El ID no puede ser nulo")
    UUID id,

    @NotNull(message = "El nombre corporativo no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre corporativo debe tener entre 3 y 100 caracteres")
    String nombreCorporativo,

    @NotNull(message = "El NIT no puede ser nulo")
    @Pattern(regexp = "^\\d{9}-[0-9]$", message = "El NIT debe tener el formato 123456789-0")
    String nit,

    @NotNull(message = "La dirección no puede ser nula")
    @Size(min = 10, max = 200, message = "La dirección debe tener entre 10 y 200 caracteres")
    String direccion,

    @NotNull(message = "El teléfono no puede ser nulo")
    @Pattern(regexp = "^\\+?[0-9\\s-]{10,15}$", message = "El teléfono debe ser válido")
    String telefono,

    @NotNull(message = "El correo electrónico no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El correo electrónico debe ser válido")
    String correoElectronico,

    @NotNull(message = "El sector no puede ser nulo")
    @Size(min = 3, max = 50, message = "El sector debe tener entre 3 y 50 caracteres")
    String sector,

    @NotNull(message = "El tamaño de la empresa no puede ser nulo")
    @Size(min = 3, max = 20, message = "El tamaño de la empresa debe tener entre 3 y 20 caracteres")
    String tamanoEmpresa,

    @NotNull(message = "La fecha de registro no puede ser nula")
    LocalDate fechaRegistro,

    BigDecimal limiteCredito,

    @Size(max = 500, message = "Las observaciones no pueden exceder los 500 caracteres")
    String observaciones
) {
    public ClienteCorporativo {
        if (limiteCredito != null && limiteCredito.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo");
        }
    }

    public ClienteCorporativo withId(UUID id) {
        return new ClienteCorporativo(
            id,
            this.nombreCorporativo,
            this.nit,
            this.direccion,
            this.telefono,
            this.correoElectronico,
            this.sector,
            this.tamanoEmpresa,
            this.fechaRegistro,
            this.limiteCredito,
            this.observaciones
        );
    }
}