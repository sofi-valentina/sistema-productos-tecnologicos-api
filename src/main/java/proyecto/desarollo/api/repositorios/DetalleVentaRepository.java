package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.DetalleVenta;

import java.util.Optional;
import java.util.UUID;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, UUID> {
  Optional<DetalleVenta> getDetalleVentaById(UUID id);
}
