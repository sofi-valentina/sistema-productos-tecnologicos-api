package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Producto;

import java.util.Optional;
import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {
  Optional<Producto> findProductoById(UUID id);
  Optional<Producto> findProductoByNombre(String nombre);
  void deleteProductoById(UUID id);
}
