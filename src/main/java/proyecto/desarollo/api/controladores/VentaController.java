package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Venta;
import proyecto.desarollo.api.servicios.VentaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class VentaController {
  private final VentaService ventaService;

  public VentaController(VentaService ventaService) {
    this.ventaService = ventaService;
  }

  @GetMapping("/ventas")
  public ResponseEntity<List<Venta>> getAllVentas() {
    List<Venta> ventas = ventaService.getAllVentas();
    return new ResponseEntity<>(ventas, HttpStatus.OK);
  }

  @GetMapping("/ventas/{ventaId}")
  public ResponseEntity<Venta> getVentaById(@PathVariable("ventaId") UUID id) {
    Venta venta = ventaService.getVentaById(id);
    return new ResponseEntity<>(venta, HttpStatus.OK);
  }

  @PostMapping("/saveVenta")
  public ResponseEntity<Venta> saveVenta(@RequestBody Venta venta) {
    Venta ventaCreada = ventaService.addVenta(venta);
    return new ResponseEntity<>(ventaCreada, HttpStatus.CREATED);
  }

  @PutMapping("/updateVenta")
  public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
    Venta ventaActualizada = ventaService.updateVenta(venta);
    return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/deleteVenta/{ventaId}")
  @Transactional
  public ResponseEntity<?> deleteVentaById(@PathVariable("ventaId") UUID id) {
    ventaService.deleteVenta(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
