package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.excepciones.ProveedorNotFoundException;
import proyecto.desarollo.api.entidades.Proveedor;
import proyecto.desarollo.api.repositorios.ProveedorRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProveedorService {
  private final ProveedorRepository proveedorRepository;

  @Autowired
  public ProveedorService(ProveedorRepository proveedorRepository) {
    this.proveedorRepository = proveedorRepository;
  }

  public Proveedor addProveedor(Proveedor proveedor) {
    proveedor.setId(UUID.randomUUID());
    return proveedorRepository.save(proveedor);
  }

  public List<Proveedor> getAllProveedores() {
    return proveedorRepository.findAll();
  }

  public Proveedor getProveedorById(UUID id) {
    return proveedorRepository
            .getProveedorById(id)
            .orElseThrow(
                    () -> new ProveedorNotFoundException("Proveedor con id " + id + " no encontrado")
            );
  }

  public Proveedor updateProveedor(Proveedor proveedor) {
    return proveedorRepository.save(proveedor);
  }

  public void deleteProveedor(UUID id) {
    proveedorRepository.deleteProveedorById(id);
  }
}
