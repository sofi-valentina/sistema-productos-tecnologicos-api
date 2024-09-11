package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.excepciones.RolNotFoundException;
import proyecto.desarollo.api.entidades.Rol;
import proyecto.desarollo.api.repositorios.RolRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RolService {
  private final RolRepository rolRepository;

  @Autowired
  public RolService(RolRepository rolRepository) {
    this.rolRepository = rolRepository;
  }

  public Rol addRol(Rol rol) {
    rol.setId(UUID.randomUUID());
    return rolRepository.save(rol);
  }

  public List<Rol> getAllRoles() {
    return rolRepository.findAll();
  }

  public Rol getRolById(UUID id) {
    return rolRepository
            .findRolById(id)
            .orElseThrow(
                    () -> new RolNotFoundException("Rol con id " + id + " no encontrado")
            );
  }

  public Rol updateRol(Rol rol) {
    return rolRepository.save(rol);
  }

  public void deleteRol(UUID id) {
    rolRepository.deleteRolById(id);
  }
}
