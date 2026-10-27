package com.pragma.backend.infrastructure.controller;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.application.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "API para gestión de clientes corporativos y retail")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/corporativo")
    @Operation(summary = "Crear cliente corporativo", description = "Registra un nuevo cliente corporativo en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente corporativo creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de cliente corporativo inválidos"),
        @ApiResponse(responseCode = "409", description = "Ya existe un cliente con ese NIT")
    })
    public ResponseEntity<ClienteCorporativo> crearClienteCorporativo(
            @Valid @RequestBody ClienteCorporativo cliente) {
        logger.info("Recibida solicitud para crear cliente corporativo con NIT: {}", cliente.nit());
        ClienteCorporativo creado = clienteService.crearClienteCorporativo(cliente);
        logger.info("Cliente corporativo creado exitosamente con ID: {}", creado.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PostMapping("/retail")
    @Operation(summary = "Crear cliente retail", description = "Registra un nuevo cliente retail en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente retail creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de cliente retail inválidos"),
        @ApiResponse(responseCode = "409", description = "Ya existe un cliente con ese número de identificación")
    })
    public ResponseEntity<ClienteRetail> crearClienteRetail(
            @Valid @RequestBody ClienteRetail cliente) {
        logger.info("Recibida solicitud para crear cliente retail con identificacion: {}", 
                    cliente.numeroIdentificacion());
        ClienteRetail creado = clienteService.crearClienteRetail(cliente);
        logger.info("Cliente retail creado exitosamente con ID: {}", creado.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping("/corporativo/{id}")
    @Operation(summary = "Obtener cliente corporativo por ID", description = "Busca un cliente corporativo por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente corporativo encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente corporativo no encontrado")
    })
    public ResponseEntity<ClienteCorporativo> obtenerCorporativoPorId(
            @Parameter(description = "UUID del cliente corporativo") @PathVariable UUID id) {
        logger.info("Buscando cliente corporativo con ID: {}", id);
        return clienteService.obtenerCorporativoPorId(id)
                .map(cliente -> {
                    logger.info("Cliente corporativo encontrado: {}", cliente.id());
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente corporativo no encontrado con ID: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/retail/{id}")
    @Operation(summary = "Obtener cliente retail por ID", description = "Busca un cliente retail por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente retail encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente retail no encontrado")
    })
    public ResponseEntity<ClienteRetail> obtenerRetailPorId(
            @Parameter(description = "UUID del cliente retail") @PathVariable UUID id) {
        logger.info("Buscando cliente retail con ID: {}", id);
        return clienteService.obtenerRetailPorId(id)
                .map(cliente -> {
                    logger.info("Cliente retail encontrado: {}", cliente.id());
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente retail no encontrado con ID: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/corporativo")
    @Operation(summary = "Listar todos los clientes corporativos", description = "Retorna una lista de todos los clientes corporativos registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes corporativos obtenida exitosamente")
    })
    public ResponseEntity<List<ClienteCorporativo>> listarClientesCorporativos() {
        logger.info("Listando todos los clientes corporativos");
        List<ClienteCorporativo> clientes = clienteService.listarTodosCorporativos();
        logger.info("Se encontraron {} clientes corporativos", clientes.size());
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/retail")
    @Operation(summary = "Listar todos los clientes retail", description = "Retorna una lista de todos los clientes retail registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes retail obtenida exitosamente")
    })
    public ResponseEntity<List<ClienteRetail>> listarClientesRetail() {
        logger.info("Listando todos los clientes retail");
        List<ClienteRetail> clientes = clienteService.listarTodosRetail();
        logger.info("Se encontraron {} clientes retail", clientes.size());
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/corporativo/{id}")
    @Operation(summary = "Eliminar cliente corporativo", description = "Elimina un cliente corporativo por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente corporativo eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente corporativo no encontrado")
    })
    public ResponseEntity<Void> eliminarClienteCorporativo(
            @Parameter(description = "UUID del cliente corporativo a eliminar") @PathVariable UUID id) {
        logger.info("Eliminando cliente corporativo con ID: {}", id);
        if (clienteService.eliminarClienteCorporativo(id)) {
            logger.info("Cliente corporativo eliminado exitosamente: {}", id);
            return ResponseEntity.noContent().build();
        }
        logger.warn("Cliente corporativo no encontrado para eliminación: {}", id);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/retail/{id}")
    @Operation(summary = "Eliminar cliente retail", description = "Elimina un cliente retail por su identificador único")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente retail eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Cliente retail no encontrado")
    })
    public ResponseEntity<Void> eliminarClienteRetail(
            @Parameter(description = "UUID del cliente retail a eliminar") @PathVariable UUID id) {
        logger.info("Eliminando cliente retail con ID: {}", id);
        if (clienteService.eliminarClienteRetail(id)) {
            logger.info("Cliente retail eliminado exitosamente: {}", id);
            return ResponseEntity.noContent().build();
        }
        logger.warn("Cliente retail no encontrado para eliminación: {}", id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/corporativo/nit/{nit}")
    @Operation(summary = "Buscar cliente corporativo por NIT", description = "Busca un cliente corporativo por su número de NIT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente corporativo encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente corporativo no encontrado")
    })
    public ResponseEntity<ClienteCorporativo> buscarCorporativoPorNit(
            @Parameter(description = "NIT del cliente corporativo") @PathVariable String nit) {
        logger.info("Buscando cliente corporativo por NIT: {}", nit);
        return clienteService.buscarCorporativoPorNit(nit)
                .map(cliente -> {
                    logger.info("Cliente corporativo encontrado por NIT: {}", nit);
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente corporativo no encontrado con NIT: {}", nit);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/retail/identificacion/{numeroIdentificacion}")
    @Operation(summary = "Buscar cliente retail por número de identificación", 
               description = "Busca un cliente retail por su número de identificación")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente retail encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente retail no encontrado")
    })
    public ResponseEntity<ClienteRetail> buscarRetailPorIdentificacion(
            @Parameter(description = "Número de identificación del cliente retail") 
            @PathVariable String numeroIdentificacion) {
        logger.info("Buscando cliente retail por identificación: {}", numeroIdentificacion);
        return clienteService.buscarRetailPorIdentificacion(numeroIdentificacion)
                .map(cliente -> {
                    logger.info("Cliente retail encontrado por identificación: {}", numeroIdentificacion);
                    return ResponseEntity.ok(cliente);
                })
                .orElseGet(() -> {
                    logger.warn("Cliente retail no encontrado con identificación: {}", numeroIdentificacion);
                    return ResponseEntity.notFound().build();
                });
    }
}