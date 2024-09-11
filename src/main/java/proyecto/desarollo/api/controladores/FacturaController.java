package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Factura;
import proyecto.desarollo.api.servicios.FacturaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class FacturaController {
  private final FacturaService facturaService;

  public FacturaController(FacturaService facturaService) {
    this.facturaService = facturaService;
  }

  @GetMapping("/facturas")
  public ResponseEntity<List<Factura>> getAllFacturas() {
    List<Factura> facturas = facturaService.getAllFacturas();
    return new ResponseEntity<>(facturas, HttpStatus.OK);
  }

  @GetMapping("/facturas/{facturaId}")
  public ResponseEntity<Factura> getFacturaById(@PathVariable("facturaId") UUID id) {
    Factura factura = facturaService.getFacturaById(id);
    return new ResponseEntity<>(factura, HttpStatus.OK);
  }

  @PostMapping("/saveFactura")
  public ResponseEntity<Factura> saveFactura(@RequestBody Factura factura) {
    Factura facturaCreada = facturaService.addFactura(factura);
    return new ResponseEntity<>(facturaCreada, HttpStatus.CREATED);
  }

  @PutMapping("/updateFactura")
  public ResponseEntity<Factura> updateFactura(@RequestBody Factura factura) {
    Factura facturaActualizada = facturaService.updateFactura(factura);
    return new ResponseEntity<>(facturaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/deleteFactura/{facturaId}")
  @Transactional
  public ResponseEntity<?> deleteFacturaById(@PathVariable("facturaId") UUID id) {
    facturaService.deleteFactura(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}