package proyecto.desarollo.api.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.desarollo.api.entidades.Rol;

import java.util.Optional;
import java.util.UUID;

public interface RolRepository extends JpaRepository<Rol, UUID> {
  Optional<Rol> findRolById(UUID id);
  Optional<Rol> findRolByNombre(String nombre);
  void deleteRolById(UUID id);
}
