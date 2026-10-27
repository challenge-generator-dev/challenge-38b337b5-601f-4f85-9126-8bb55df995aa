package com.pragma.backend.infrastructure.adapter;

import com.pragma.backend.infrastructure.adapter.entity.ClienteRetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaClienteRetailRepository extends JpaRepository<ClienteRetailEntity, UUID> {
    Optional<ClienteRetailEntity> findByNumeroIdentificacion(String numeroIdentificacion);
}