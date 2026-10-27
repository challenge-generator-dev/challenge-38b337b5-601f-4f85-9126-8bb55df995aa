package com.pragma.backend.application.service;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.domain.port.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias del servicio de clientes")
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
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
    @DisplayName("Escenario: Guardar clientes corporativos")
    class GuardarClienteCorporativo {

        @Test
        @DisplayName("Debe guardar cliente corporativo exitosamente")
        void debeGuardarClienteCorporativoExitosamente() {
            when(clienteRepository.saveCorporativo(any(ClienteCorporativo.class)))
                .thenReturn(clienteCorporativoMock);

            ClienteCorporativo resultado = clienteService.guardarClienteCorporativo(
                "12345678-9",
                "Empresa SAS",
                "contacto@empresa.com",
                "Calle 123",
                new BigDecimal("1000000")
            );

            assertThat(resultado).isNotNull();
            assertThat(resultado.nit()).isEqualTo("12345678-9");
            assertThat(resultado.razonSocial()).isEqualTo("Empresa SAS");
            verify(clienteRepository, times(1)).saveCorporativo(any(ClienteCorporativo.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el NIT ya existe")
        void debeLanzarExcepcionCuandoNitYaExiste() {
            when(clienteRepository.findCorporativoByNit("12345678-9"))
                .thenReturn(Optional.of(clienteCorporativoMock));

            assertThatThrownBy(() -> clienteService.guardarClienteCorporativo(
                "12345678-9",
                "Empresa SAS",
                "contacto@empresa.com",
                "Calle 123",
                new BigDecimal("1000000")
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("NIT ya registrado");

            verify(clienteRepository, never()).saveCorporativo(any());
        }
    }

    @Nested
    @DisplayName("Escenario: Guardar clientes retail")
    class GuardarClienteRetail {

        @Test
        @DisplayName("Debe guardar cliente retail exitosamente")
        void debeGuardarClienteRetailExitosamente() {
            when(clienteRepository.saveRetail(any(ClienteRetail.class)))
                .thenReturn(clienteRetailMock);

            ClienteRetail resultado = clienteService.guardarClienteRetail(
                "1000000001",
                "Juan Perez",
                "juan@email.com",
                "Carrera 45 #67-89",
                new BigDecimal("50000"),
                LocalDate.of(1990, 5, 15)
            );

            assertThat(resultado).isNotNull();
            assertThat(resultado.numeroIdentificacion()).isEqualTo("1000000001");
            assertThat(resultado.nombre()).isEqualTo("Juan Perez");
            verify(clienteRepository, times(1)).saveRetail(any(ClienteRetail.class));
        }

        @Test
        @DisplayName("Debe lanzar excepción cuando el número de identificación ya existe")
        void debeLanzarExcepcionCuandoNumeroIdentificacionYaExiste() {
            when(clienteRepository.findRetailByNumeroIdentificacion("1000000001"))
                .thenReturn(Optional.of(clienteRetailMock));

            assertThatThrownBy(() -> clienteService.guardarClienteRetail(
                "1000000001",
                "Juan Perez",
                "juan@email.com",
                "Carrera 45 #67-89",
                new BigDecimal("50000"),
                LocalDate.of(1990, 5, 15)
            )).isInstanceOf(IllegalArgumentException.class)
              .hasMessageContaining("identificación ya registrada");

            verify(clienteRepository, never()).saveRetail(any());
        }
    }

    @Nested
    @DisplayName("Escenario: Buscar clientes por ID")
    class BuscarClientePorId {

        @Test
        @DisplayName("Debe encontrar cliente corporativo por ID")
        void debeEncontrarClienteCorporativoPorId() {
            when(clienteRepository.findCorporativoById(idCorporativo))
                .thenReturn(Optional.of(clienteCorporativoMock));

            Optional<ClienteCorporativo> resultado = clienteService
                .buscarClienteCorporativoPorId(idCorporativo);

            assertThat(resultado).isPresent();
            assertThat(resultado.get().nit()).isEqualTo("12345678-9");
        }

        @Test
        @DisplayName("Debe retornar vacío cuando cliente corporativo no existe")
        void debeRetornarVacioCuandoClienteCorporativoNoExiste() {
            UUID idNoExistente = UUID.randomUUID();
            when(clienteRepository.findCorporativoById(idNoExistente))
                .thenReturn(Optional.empty());

            Optional<ClienteCorporativo> resultado = clienteService
                .buscarClienteCorporativoPorId(idNoExistente);

            assertThat(resultado).isEmpty();
        }

        @Test
        @DisplayName("Debe encontrar cliente retail por ID")
        void debeEncontrarClienteRetailPorId() {
            when(clienteRepository.findRetailById(idRetail))
                .thenReturn(Optional.of(clienteRetailMock));

            Optional<ClienteRetail> resultado = clienteService
                .buscarClienteRetailPorId(idRetail);

            assertThat(resultado).isPresent();
            assertThat(resultado.get().numeroIdentificacion()).isEqualTo("1000000001");
        }
    }

    @Nested
    @DisplayName("Escenario: Listar todos los clientes")
    class ListarClientes {

        @Test
        @DisplayName("Debe listar todos los clientes corporativos")
        void debeListarTodosLosClientesCorporativos() {
            when(clienteRepository.findAllCorporativos())
                .thenReturn(List.of(clienteCorporativoMock));

            List<ClienteCorporativo> resultado = clienteService.listarClientesCorporativos();

            assertThat(resultado).hasSize(1);
            assertThat(resultado.get(0).nit()).isEqualTo("12345678-9");
        }

        @Test
        @DisplayName("Debe listar todos los clientes retail")
        void debeListarTodosLosClientesRetail() {
            when(clienteRepository.findAllRetail())
                .thenReturn(List.of(clienteRetailMock));

            List<ClienteRetail> resultado = clienteService.listarClientesRetail();

            assertThat(resultado).hasSize(1);
            assertThat(resultado.get(0).numeroIdentificacion()).isEqualTo("1000000001");
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay clientes corporativos")
        void debeRetornarListaVaciaCuandoNoHayClientesCorporativos() {
            when(clienteRepository.findAllCorporativos())
                .thenReturn(List.of());

            List<ClienteCorporativo> resultado = clienteService.listarClientesCorporativos();

            assertThat(resultado).isEmpty();
        }
    }

    @Nested
    @DisplayName("Escenario: Eliminar clientes")
    class EliminarClientes {

        @Test
        @DisplayName("Debe eliminar cliente corporativo por ID")
        void debeEliminarClienteCorporativoPorId() {
            doNothing().when(clienteRepository).deleteCorporativo(idCorporativo);

            clienteService.eliminarClienteCorporativo(idCorporativo);

            verify(clienteRepository, times(1)).deleteCorporativo(idCorporativo);
        }

        @Test
        @DisplayName("Debe eliminar cliente retail por ID")
        void debeEliminarClienteRetailPorId() {
            doNothing().when(clienteRepository).deleteRetail(idRetail);

            clienteService.eliminarClienteRetail(idRetail);

            verify(clienteRepository, times(1)).deleteRetail(idRetail);
        }
    }
}