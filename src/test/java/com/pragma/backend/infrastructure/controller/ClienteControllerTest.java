package com.pragma.backend.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.backend.application.service.ClienteService;
import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
@DisplayName("Pruebas de integración del controlador de clientes")
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClienteService clienteService;

    private ClienteCorporativo clienteCorporativoMock;
    private ClienteRetail clienteRetailMock;
    private UUID idCorporativo;
    private UUID idRetail;

    @BeforeEach
    void setUp() {
        idCorporativo = UUID.randomUUID();
        idRetail = UUID.randomUUID();

        clienteCorporativoMock = new ClienteCorporativo(
            idCorporativo,
            "12345678-9",
            "Empresa SAS",
            "contacto@empresa.com",
            "Calle 123",
            new BigDecimal("1000000"),
            LocalDate.now()
        );

        clienteRetailMock = new ClienteRetail(
            idRetail,
            "1000000001",
            "Juan Perez",
            "juan@email.com",
            "Carrera 45 #67-89",
            new BigDecimal("50000"),
            LocalDate.of(1990, 5, 15)
        );
    }

    @Nested
    @DisplayName("API: Endpoints de clientes corporativos")
    class EndpointsClientesCorporativos {

        @Test
        @DisplayName("POST /api/clientes/corporativos debe crear cliente corporativo")
        void postDebeCrearClienteCorporativo() throws Exception {
            when(clienteService.guardarClienteCorporativo(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class))
            ).thenReturn(clienteCorporativoMock);

            mockMvc.perform(post("/api/clientes/corporativos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "nit": "12345678-9",
                            "razonSocial": "Empresa SAS",
                            "correoContacto": "contacto@empresa.com",
                            "direccion": "Calle 123",
                            "cupoCredito": 1000000
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nit").value("12345678-9"))
                .andExpect(jsonPath("$.razonSocial").value("Empresa SAS"));

            verify(clienteService, times(1)).guardarClienteCorporativo(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class));
        }

        @Test
        @DisplayName("GET /api/clientes/corporativos/{id} debe retornar cliente corporativo")
        void getDebeRetornarClienteCorporativo() throws Exception {
            when(clienteService.buscarClienteCorporativoPorId(idCorporativo))
                .thenReturn(Optional.of(clienteCorporativoMock));

            mockMvc.perform(get("/api/clientes/corporativos/{id}", idCorporativo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nit").value("12345678-9"))
                .andExpect(jsonPath("$.razonSocial").value("Empresa SAS"));
        }

        @Test
        @DisplayName("GET /api/clientes/corporativos/{id} debe retornar 404 cuando no existe")
        void getDebeRetornar404CuandoNoExiste() throws Exception {
            UUID idNoExistente = UUID.randomUUID();
            when(clienteService.buscarClienteCorporativoPorId(idNoExistente))
                .thenReturn(Optional.empty());

            mockMvc.perform(get("/api/clientes/corporativos/{id}", idNoExistente))
                .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("GET /api/clientes/corporativos debe listar todos los corporativos")
        void getDebeListarTodosLosCorporativos() throws Exception {
            when(clienteService.listarClientesCorporativos())
                .thenReturn(List.of(clienteCorporativoMock));

            mockMvc.perform(get("/api/clientes/corporativos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nit").value("12345678-9"));
        }

        @Test
        @DisplayName("DELETE /api/clientes/corporativos/{id} debe eliminar cliente corporativo")
        void deleteDebeEliminarClienteCorporativo() throws Exception {
            doNothing().when(clienteService).eliminarClienteCorporativo(idCorporativo);

            mockMvc.perform(delete("/api/clientes/corporativos/{id}", idCorporativo))
                .andExpect(status().isNoContent());

            verify(clienteService, times(1)).eliminarClienteCorporativo(idCorporativo);
        }
    }

    @Nested
    @DisplayName("API: Endpoints de clientes retail")
    class EndpointsClientesRetail {

        @Test
        @DisplayName("POST /api/clientes/retail debe crear cliente retail")
        void postDebeCrearClienteRetail() throws Exception {
            when(clienteService.guardarClienteRetail(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class), any(LocalDate.class))
            ).thenReturn(clienteRetailMock);

            mockMvc.perform(post("/api/clientes/retail")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "numeroIdentificacion": "1000000001",
                            "nombre": "Juan Perez",
                            "correo": "juan@email.com",
                            "direccion": "Carrera 45 #67-89",
                            "ingresoMensual": 50000,
                            "fechaNacimiento": "1990-05-15"
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeroIdentificacion").value("1000000001"))
                .andExpect(jsonPath("$.nombre").value("Juan Perez"));

            verify(clienteService, times(1)).guardarClienteRetail(
                anyString(), anyString(), anyString(), anyString(), any(BigDecimal.class), any(LocalDate.class));
        }

        @Test
        @DisplayName("GET /api/clientes/retail/{id} debe retornar cliente retail")
        void getDebeRetornarClienteRetail() throws Exception {
            when(clienteService.buscarClienteRetailPorId(idRetail))
                .thenReturn(Optional.of(clienteRetailMock));

            mockMvc.perform(get("/api/clientes/retail/{id}", idRetail))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroIdentificacion").value("1000000001"))
                .andExpect(jsonPath("$.nombre").value("Juan Perez"));
        }

        @Test
        @DisplayName("GET /api/clientes/retail/{id} debe retornar 404 cuando no existe")
        void getDebeRetornar404CuandoNoExisteRetail() throws Exception {
            UUID idNoExistente = UUID.randomUUID();
            when(clienteService.buscarClienteRetailPorId(idNoExistente))
                .thenReturn(Optional.empty());

            mockMvc.perform(get("/api/clientes/retail/{id}", idNoExistente))
                .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("GET /api/clientes/retail debe listar todos los retail")
        void getDebeListarTodosLosRetail() throws Exception {
            when(clienteService.listarClientesRetail())
                .thenReturn(List.of(clienteRetailMock));

            mockMvc.perform(get("/api/clientes/retail"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].numeroIdentificacion").value("1000000001"));
        }

        @Test
        @DisplayName("DELETE /api/clientes/retail/{id} debe eliminar cliente retail")
        void deleteDebeEliminarClienteRetail() throws Exception {
            doNothing().when(clienteService).eliminarClienteRetail(idRetail);

            mockMvc.perform(delete("/api/clientes/retail/{id}", idRetail))
                .andExpect(status().isNoContent());

            verify(clienteService, times(1)).eliminarClienteRetail(idRetail);
        }
    }

    @Nested
    @DisplayName("API: Validaciones de entrada")
    class ValidacionesEntrada {

        @Test
        @DisplayName("POST /api/clientes/corporativos debe retornar 400 con datos inválidos")
        void postDebeRetornar400DatosInvalidos() throws Exception {
            mockMvc.perform(post("/api/clientes/corporativos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "nit": "",
                            "razonSocial": "",
                            "correoContacto": "correo-invalido",
                            "direccion": "Calle 123",
                            "cupoCredito": -100
                        }
                        """))
                .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("POST /api/clientes/retail debe retornar 400 con datos inválidos")
        void postRetailDebeRetornar400DatosInvalidos() throws Exception {
            mockMvc.perform(post("/api/clientes/retail")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                        {
                            "numeroIdentificacion": "",
                            "nombre": "",
                            "correo": "no-es-correo",
                            "direccion": "Carrera 45",
                            "ingresoMensual": -500,
                            "fechaNacimiento": "fecha-invalida"
                        }
                        """))
                .andExpect(status().isBadRequest());
        }
    }
}