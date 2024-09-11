package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Compra;

import java.util.Optional;
import java.util.UUID;

public interface CompraRepository extends JpaRepository<Compra, UUID> {
  Optional<Compra> getCompraById(UUID id);
}
