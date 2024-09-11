package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Categoria;

import java.util.Optional;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
  Optional<Categoria> findCategoriaById(UUID id);
  Optional<Categoria> findCategoriaByNombre(String nombre);
  void deleteCategoriaById(UUID id);
}
