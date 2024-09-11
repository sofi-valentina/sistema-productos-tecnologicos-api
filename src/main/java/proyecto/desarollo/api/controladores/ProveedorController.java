package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Proveedor;
import proyecto.desarollo.api.servicios.ProveedorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ProveedorController {
  private final ProveedorService proveedorService;

  public ProveedorController(ProveedorService proveedorService) {
    this.proveedorService = proveedorService;
  }

  @GetMapping("/proveedores")
  public ResponseEntity<List<Proveedor>> getAllProveedores() {
    List<Proveedor> proveedores = proveedorService.getAllProveedores();
    return new ResponseEntity<>(proveedores, HttpStatus.OK);
  }

  @GetMapping("/proveedores/{proveedorId}")
  public ResponseEntity<Proveedor> getProveedorById(@PathVariable("proveedorId") UUID proveedorId) {
    Proveedor proveedor = proveedorService.getProveedorById(proveedorId);
    return new ResponseEntity<>(proveedor, HttpStatus.OK);
  }

  @PostMapping("/saveProveedor")
  public ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) {
    Proveedor proveedorCreado = proveedorService.addProveedor(proveedor);
    return new ResponseEntity<>(proveedorCreado, HttpStatus.CREATED);
  }

  @PutMapping("/updateProveedor")
  public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
    Proveedor proveedorActualizado = proveedorService.updateProveedor(proveedor);
    return new ResponseEntity<>(proveedorActualizado, HttpStatus.OK);
  }

  @DeleteMapping("/deleteProveedor/{proveedorId}")
  @Transactional
  public ResponseEntity<Void> deleteProveedorById(@PathVariable("proveedorId") UUID proveedorId) {
    proveedorService.deleteProveedor(proveedorId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
