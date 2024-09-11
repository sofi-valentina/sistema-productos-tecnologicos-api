package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.entidades.Compra;
import proyecto.desarollo.api.repositorios.CompraRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CompraService {
  private final CompraRepository compraRepository;

  @Autowired
  public CompraService(CompraRepository compraRepository) {
    this.compraRepository = compraRepository;
  }

  public Compra addCompra(Compra compra) {
    compra.setId(UUID.randomUUID());
    return compraRepository.save(compra);
  }

  public List<Compra> getAllCompras() {
    return compraRepository.findAll();
  }

  public Compra getCompraById(UUID id) {
    return compraRepository
            .getCompraById(id)
            .orElseThrow(() -> new RuntimeException("Compra con id " + id + " no se encontró"));
  }

  public Compra updateCompra(Compra compra) {
    return compraRepository.save(compra);
  }

  public void deleteCompra(UUID id) {
    compraRepository.deleteById(id);
  }
}
