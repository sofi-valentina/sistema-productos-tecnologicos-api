package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.entidades.DetalleVenta;
import proyecto.desarollo.api.repositorios.DetalleVentaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DetalleVentaService {
  private final DetalleVentaRepository detalleVentaRepository;

  @Autowired
  public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
    this.detalleVentaRepository = detalleVentaRepository;
  }

  public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta) {
    detalleVenta.setId(UUID.randomUUID());
    return detalleVentaRepository.save(detalleVenta);
  }

  public List<DetalleVenta> getAllDetalleVentas() {
    return detalleVentaRepository.findAll();
  }

  public DetalleVenta getDetalleVentaById(UUID id) {
    return detalleVentaRepository
            .getDetalleVentaById(id)
            .orElseThrow(() -> new RuntimeException("DetalleVenta con id " + id + " no se encontró"));
  }

  public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta) {
    return detalleVentaRepository.save(detalleVenta);
  }

  public void deleteDetalleVenta(UUID id) {
    detalleVentaRepository.deleteById(id);
  }
}
