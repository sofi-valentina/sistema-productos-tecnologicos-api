package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.DetalleVenta;
import proyecto.desarollo.api.servicios.DetalleVentaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class DetalleVentaController {
  private final DetalleVentaService detalleVentaService;

  public DetalleVentaController(DetalleVentaService detalleVentaService) {
    this.detalleVentaService = detalleVentaService;
  }

  @GetMapping("/detalleVentas")
  public ResponseEntity<List<DetalleVenta>> getAllDetalleVentas() {
    List<DetalleVenta> detalleVentas = detalleVentaService.getAllDetalleVentas();
    return new ResponseEntity<>(detalleVentas, HttpStatus.OK);
  }

  @GetMapping("/detalleVentas/{detalleVentaId}")
  public ResponseEntity<DetalleVenta> getDetalleVentaById(@PathVariable("detalleVentaId") UUID id) {
    DetalleVenta detalleVenta = detalleVentaService.getDetalleVentaById(id);
    return new ResponseEntity<>(detalleVenta, HttpStatus.OK);
  }

  @PostMapping("/saveDetalleVenta")
  public ResponseEntity<DetalleVenta> saveDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
    DetalleVenta detalleVentaCreada = detalleVentaService.addDetalleVenta(detalleVenta);
    return new ResponseEntity<>(detalleVentaCreada, HttpStatus.CREATED);
  }

  @PutMapping("/updateDetalleVenta")
  public ResponseEntity<DetalleVenta> updateDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
    DetalleVenta detalleVentaActualizada = detalleVentaService.updateDetalleVenta(detalleVenta);
    return new ResponseEntity<>(detalleVentaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/deleteDetalleVenta/{detalleVentaId}")
  @Transactional
  public ResponseEntity<?> deleteDetalleVentaById(@PathVariable("detalleVentaId") UUID id) {
    detalleVentaService.deleteDetalleVenta(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
