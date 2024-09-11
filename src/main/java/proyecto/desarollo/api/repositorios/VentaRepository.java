package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Venta;

import java.util.Optional;
import java.util.UUID;

public interface VentaRepository extends JpaRepository<Venta, UUID> {
  Optional<Venta> getVentaById(UUID id);
}
