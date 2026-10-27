package com.pragma.backend.application.service;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.domain.port.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteCorporativo crearClienteCorporativo(ClienteCorporativo cliente) {
        logger.info("Creando cliente corporativo con NIT: {}", cliente.nit());

        Optional<ClienteCorporativo> existente = clienteRepository.findCorporativoByNit(cliente.nit());
        if (existente.isPresent()) {
            logger.warn("Ya existe cliente corporativo con NIT: {}", cliente.nit());
            throw new ClienteExistenteException("Ya existe un cliente corporativo con el NIT: " + cliente.nit());
        }

        ClienteCorporativo guardado = clienteRepository.saveCorporativo(cliente);
        logger.info("Cliente corporativo creado exitosamente con ID: {}", guardado.id());
        return guardado;
    }

    @Transactional
    public ClienteRetail crearClienteRetail(ClienteRetail cliente) {
        logger.info("Creando cliente retail con identificacion: {}", cliente.numeroIdentificacion());

        Optional<ClienteRetail> existente = clienteRepository.findRetailByNumeroIdentificacion(cliente.numeroIdentificacion());
        if (existente.isPresent()) {
            logger.warn("Ya existe cliente retail con identificacion: {}", cliente.numeroIdentificacion());
            throw new ClienteExistenteException("Ya existe un cliente retail con el numero de identificacion: " + cliente.numeroIdentificacion());
        }

        ClienteRetail guardado = clienteRepository.saveRetail(cliente);
        logger.info("Cliente retail creado exitosamente con ID: {}", guardado.id());
        return guardado;
    }

    @Transactional(readOnly = true)
    public Optional<ClienteCorporativo> obtenerClienteCorporativo(UUID id) {
        logger.debug("Obteniendo cliente corporativo con ID: {}", id);
        return clienteRepository.findCorporativoById(id);
    }

    @Transactional(readOnly = true)
    public Optional<ClienteRetail> obtenerClienteRetail(UUID id) {
        logger.debug("Obteniendo cliente retail con ID: {}", id);
        return clienteRepository.findRetailById(id);
    }

    @Transactional(readOnly = true)
    public List<ClienteCorporativo> listarClientesCorporativos() {
        logger.debug("Listando todos los clientes corporativos");
        return clienteRepository.findAllCorporativos();
    }

    @Transactional(readOnly = true)
    public List<ClienteRetail> listarClientesRetail() {
        logger.debug("Listando todos los clientes retail");
        return clienteRepository.findAllRetail();
    }

    @Transactional
    public void eliminarClienteCorporativo(UUID id) {
        logger.info("Eliminando cliente corporativo con ID: {}", id);
        Optional<ClienteCorporativo> existente = clienteRepository.findCorporativoById(id);
        if (existente.isEmpty()) {
            logger.warn("No se encontro cliente corporativo con ID: {}", id);
            throw new ClienteNoEncontradoException("No se encontro el cliente corporativo con ID: " + id);
        }
        clienteRepository.deleteCorporativo(id);
        logger.info("Cliente corporativo eliminado exitosamente");
    }

    @Transactional
    public void eliminarClienteRetail(UUID id) {
        logger.info("Eliminando cliente retail con ID: {}", id);
        Optional<ClienteRetail> existente = clienteRepository.findRetailById(id);
        if (existente.isEmpty()) {
            logger.warn("No se encontro cliente retail con ID: {}", id);
            throw new ClienteNoEncontradoException("No se encontro el cliente retail con ID: " + id);
        }
        clienteRepository.deleteRetail(id);
        logger.info("Cliente retail eliminado exitosamente");
    }

    public static class ClienteExistenteException extends RuntimeException {
        public ClienteExistenteException(String message) {
            super(message);
        }
    }

    public static class ClienteNoEncontradoException extends RuntimeException {
        public ClienteNoEncontradoException(String message) {
            super(message);
        }
    }
}