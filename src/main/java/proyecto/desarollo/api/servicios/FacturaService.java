package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.entidades.Factura;
import proyecto.desarollo.api.repositorios.FacturaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FacturaService {
  private final FacturaRepository facturaRepository;

  @Autowired
  public FacturaService(FacturaRepository facturaRepository) {
    this.facturaRepository = facturaRepository;
  }

  public Factura addFactura(Factura factura) {
    factura.setId(UUID.randomUUID());
    return facturaRepository.save(factura);
  }

  public List<Factura> getAllFacturas() {
    return facturaRepository.findAll();
  }

  public Factura getFacturaById(UUID id) {
    return facturaRepository
            .getFacturaById(id)
            .orElseThrow(() -> new RuntimeException("Factura con id " + id + " no se encontró"));
  }

  public Factura updateFactura(Factura factura) {
    return facturaRepository.save(factura);
  }

  public void deleteFactura(UUID id) {
    facturaRepository.deleteById(id);
  }
}
