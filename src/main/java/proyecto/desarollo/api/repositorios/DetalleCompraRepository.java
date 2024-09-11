package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.DetalleCompra;

import java.util.Optional;
import java.util.UUID;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, UUID> {
  Optional<DetalleCompra> getDetalleCompraById(UUID id);
}
