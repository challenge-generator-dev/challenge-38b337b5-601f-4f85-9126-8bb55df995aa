package com.pragma.backend.domain.port;

import com.pragma.backend.domain.model.ClienteCorporativo;
import com.pragma.backend.domain.model.ClienteRetail;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    ClienteCorporativo saveCorporativo(ClienteCorporativo cliente);
    ClienteRetail saveRetail(ClienteRetail cliente);

    Optional<ClienteCorporativo> findCorporativoById(UUID id);
    Optional<ClienteRetail> findRetailById(UUID id);

    List<ClienteCorporativo> findAllCorporativos();
    List<ClienteRetail> findAllRetail();

    void deleteCorporativo(UUID id);
    void deleteRetail(UUID id);

    Optional<ClienteCorporativo> findCorporativoByNit(String nit);
    Optional<ClienteRetail> findRetailByNumeroIdentificacion(String numeroIdentificacion);
}