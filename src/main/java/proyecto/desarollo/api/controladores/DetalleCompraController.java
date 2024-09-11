package proyecto.desarollo.api.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.DetalleCompra;
import proyecto.desarollo.api.servicios.DetalleCompraService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class DetalleCompraController {
  private final DetalleCompraService detalleCompraService;

  @Autowired
  public DetalleCompraController(DetalleCompraService detalleCompraService) {
    this.detalleCompraService = detalleCompraService;
  }

  @GetMapping("/detalleCompras")
  public ResponseEntity<List<DetalleCompra>> getAllDetalleCompras() {
    List<DetalleCompra> detalleCompras = detalleCompraService.getAllDetalleCompras();
    return new ResponseEntity<>(detalleCompras, HttpStatus.OK);
  }

  @GetMapping("/detalleCompras/{detalleCompraId}")
  public ResponseEntity<DetalleCompra> getDetalleCompraById(@PathVariable("detalleCompraId") UUID id) {
    DetalleCompra detalleCompra = detalleCompraService.getDetalleCompraById(id);
    return new ResponseEntity<>(detalleCompra, HttpStatus.OK);
  }

  @PostMapping("/saveDetalleCompra")
  public ResponseEntity<DetalleCompra> saveDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
    DetalleCompra detalleCompraCreada = detalleCompraService.addDetalleCompra(detalleCompra);
    return new ResponseEntity<>(detalleCompraCreada, HttpStatus.CREATED);
  }

  @PutMapping("/updateDetalleCompra")
  public ResponseEntity<DetalleCompra> updateDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
    DetalleCompra detalleCompraActualizada = detalleCompraService.updateDetalleCompra(detalleCompra);
    return new ResponseEntity<>(detalleCompraActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/deleteDetalleCompra/{detalleCompraId}")
  public ResponseEntity<?> deleteDetalleCompraById(@PathVariable("detalleCompraId") UUID id) {
    detalleCompraService.deleteDetalleCompra(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
