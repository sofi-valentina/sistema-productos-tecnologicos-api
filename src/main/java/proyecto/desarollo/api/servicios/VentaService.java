package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.entidades.Venta;
import proyecto.desarollo.api.repositorios.VentaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class VentaService {
  private final VentaRepository ventaRepository;

  @Autowired
  public VentaService(VentaRepository ventaRepository) {
    this.ventaRepository = ventaRepository;
  }

  public Venta addVenta(Venta venta) {
    venta.setId(UUID.randomUUID());
    return ventaRepository.save(venta);
  }

  public List<Venta> getAllVentas() {
    return ventaRepository.findAll();
  }

  public Venta getVentaById(UUID id) {
    return ventaRepository
            .getVentaById(id)
            .orElseThrow(() -> new RuntimeException("Venta con id " + id + " no se encontró"));
  }

  public Venta updateVenta(Venta venta) {
    return ventaRepository.save(venta);
  }

  public void deleteVenta(UUID id) {
    ventaRepository.deleteById(id);
  }
}
