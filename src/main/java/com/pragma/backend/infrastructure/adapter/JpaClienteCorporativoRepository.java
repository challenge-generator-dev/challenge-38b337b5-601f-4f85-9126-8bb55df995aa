package com.pragma.backend.infrastructure.adapter;

import com.pragma.backend.infrastructure.adapter.entity.ClienteCorporativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaClienteCorporativoRepository extends JpaRepository<ClienteCorporativoEntity, UUID> {
    Optional<ClienteCorporativoEntity> findByNit(String nit);
}