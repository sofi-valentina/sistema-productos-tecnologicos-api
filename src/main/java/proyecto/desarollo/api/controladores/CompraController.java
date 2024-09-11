package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Compra;
import proyecto.desarollo.api.servicios.CompraService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class CompraController {

  private final CompraService compraService;

  public CompraController(CompraService compraService) {
    this.compraService = compraService;
  }

  @GetMapping("/compras")
  public ResponseEntity<List<Compra>> getAllCompras() {
    List<Compra> compras = compraService.getAllCompras();
    return new ResponseEntity<>(compras, HttpStatus.OK);
  }

  @GetMapping("/compras/{compraId}")
  public ResponseEntity<Compra> getCompraById(@PathVariable("compraId") UUID id) {
    Compra compra = compraService.getCompraById(id);
    return new ResponseEntity<>(compra, HttpStatus.OK);
  }

  @PostMapping("/saveCompra")
  public ResponseEntity<Compra> saveCompra(@RequestBody Compra compra) {
    Compra compraCreada = compraService.addCompra(compra);
    return new ResponseEntity<>(compraCreada, HttpStatus.CREATED);
  }

  @PutMapping("/updateCompra")
  public ResponseEntity<Compra> updateCompra(@RequestBody Compra compra) {
    Compra compraActualizada = compraService.updateCompra(compra);
    return new ResponseEntity<>(compraActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/deleteCompra/{compraId}")
  @Transactional
  public ResponseEntity<?> deleteCompraById(@PathVariable("compraId") UUID id) {
    compraService.deleteCompra(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
