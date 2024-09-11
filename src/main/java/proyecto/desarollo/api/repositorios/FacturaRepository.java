package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Factura;

import java.util.Optional;
import java.util.UUID;

public interface FacturaRepository extends JpaRepository<Factura, UUID> {
  Optional<Factura> getFacturaById(UUID id);
}
