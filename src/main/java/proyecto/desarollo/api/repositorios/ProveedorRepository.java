package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Proveedor;

import java.util.Optional;
import java.util.UUID;

public interface ProveedorRepository extends JpaRepository<Proveedor, UUID> {
  Optional<Proveedor> getProveedorById(UUID id);
  void deleteProveedorById(UUID id);
}
