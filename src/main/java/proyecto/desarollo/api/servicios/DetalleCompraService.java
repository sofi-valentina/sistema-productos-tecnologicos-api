package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.entidades.DetalleCompra;
import proyecto.desarollo.api.repositorios.DetalleCompraRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DetalleCompraService {
  private final DetalleCompraRepository detalleCompraRepository;

  @Autowired
  public DetalleCompraService(DetalleCompraRepository detalleCompraRepository) {
    this.detalleCompraRepository = detalleCompraRepository;
  }

  public DetalleCompra addDetalleCompra(DetalleCompra detalleCompra) {
    detalleCompra.setId(UUID.randomUUID());
    return detalleCompraRepository.save(detalleCompra);
  }

  public List<DetalleCompra> getAllDetalleCompras() {
    return detalleCompraRepository.findAll();
  }

  public DetalleCompra getDetalleCompraById(UUID id) {
    return detalleCompraRepository
            .getDetalleCompraById(id)
            .orElseThrow(() -> new RuntimeException("DetalleCompra con id " + id + " no se encontró"));
  }

  public DetalleCompra updateDetalleCompra(DetalleCompra detalleCompra) {
    return detalleCompraRepository.save(detalleCompra);
  }

  public void deleteDetalleCompra(UUID id) {
    detalleCompraRepository.deleteById(id);
  }
}
