package com.pragma.backend.infrastructure.adapter;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import com.pragma.backend.domain.port.ClienteRepository;
import com.pragma.backend.infrastructure.adapter.entity.ClienteCorporativoEntity;
import com.pragma.backend.infrastructure.adapter.entity.ClienteRetailEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaClienteRepository implements ClienteRepository {

    private final JpaClienteCorporativoRepository corporativoRepository;
    private final JpaClienteRetailRepository retailRepository;

    public JpaClienteRepository(JpaClienteCorporativoRepository corporativoRepository,
                                 JpaClienteRetailRepository retailRepository) {
        this.corporativoRepository = corporativoRepository;
        this.retailRepository = retailRepository;
    }

    @Override
    public ClienteCorporativo saveCorporativo(ClienteCorporativo cliente) {
        ClienteCorporativoEntity entity = toCorporativoEntity(cliente);
        entity.setFechaCreacion(LocalDateTime.now());
        ClienteCorporativoEntity saved = corporativoRepository.save(entity);
        return toCorporativoModel(saved);
    }

    @Override
    public ClienteRetail saveRetail(ClienteRetail cliente) {
        ClienteRetailEntity entity = toRetailEntity(cliente);
        entity.setFechaCreacion(LocalDateTime.now());
        ClienteRetailEntity saved = retailRepository.save(entity);
        return toRetailModel(saved);
    }

    @Override
    public Optional<ClienteCorporativo> findCorporativoById(UUID id) {
        return corporativoRepository.findById(id).map(this::toCorporativoModel);
    }

    @Override
    public Optional<ClienteRetail> findRetailById(UUID id) {
        return retailRepository.findById(id).map(this::toRetailModel);
    }

    @Override
    public List<ClienteCorporativo> findAllCorporativos() {
        return corporativoRepository.findAll().stream()
                .map(this::toCorporativoModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteRetail> findAllRetail() {
        return retailRepository.findAll().stream()
                .map(this::toRetailModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCorporativo(UUID id) {
        corporativoRepository.deleteById(id);
    }

    @Override
    public void deleteRetail(UUID id) {
        retailRepository.deleteById(id);
    }

    @Override
    public Optional<ClienteCorporativo> findCorporativoByNit(String nit) {
        return corporativoRepository.findByNit(nit).map(this::toCorporativoModel);
    }

    @Override
    public Optional<ClienteRetail> findRetailByNumeroIdentificacion(String numeroIdentificacion) {
        return retailRepository.findByNumeroIdentificacion(numeroIdentificacion).map(this::toRetailModel);
    }

    private ClienteCorporativo toCorporativoModel(ClienteCorporativoEntity entity) {
        return new ClienteCorporativo(
                entity.getId(),
                entity.getNit(),
                entity.getRazonSocial(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    private ClienteCorporativoEntity toCorporativoEntity(ClienteCorporativo model) {
        ClienteCorporativoEntity entity = new ClienteCorporativoEntity(
                model.nit(),
                model.razonSocial(),
                model.email(),
                model.telefono(),
                model.direccion()
        );
        if (model.id() != null) {
            entity.setId(model.id());
        }
        return entity;
    }

    private ClienteRetail toRetailModel(ClienteRetailEntity entity) {
        return new ClienteRetail(
                entity.getId(),
                entity.getNumeroIdentificacion(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    private ClienteRetailEntity toRetailEntity(ClienteRetail model) {
        ClienteRetailEntity entity = new ClienteRetailEntity(
                model.numeroIdentificacion(),
                model.nombres(),
                model.apellidos(),
                model.email(),
                model.telefono(),
                model.direccion()
        );
        if (model.id() != null) {
            entity.setId(model.id());
        }
        return entity;
    }
}