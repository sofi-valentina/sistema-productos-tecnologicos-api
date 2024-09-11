package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Producto;
import proyecto.desarollo.api.servicios.ProductoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
  private final ProductoService productoService;

  public ProductoController(ProductoService productoService) {
    this.productoService = productoService;
  }

  @GetMapping("/productos")
  public ResponseEntity<List<Producto>> getProductos() {
    List<Producto> productos = productoService.getAllProductos();
    return new ResponseEntity<>(productos, HttpStatus.OK);
  }

  @GetMapping("/productos/{productoId}")
  public ResponseEntity<Producto> getProductoById(@PathVariable("productoId") UUID id) {
    Producto producto = productoService.getProductoById(id);
    return new ResponseEntity<>(producto, HttpStatus.OK);
  }

  @PostMapping("/saveProducto")
  public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
    Producto productoCreado = productoService.addProducto(producto);
    return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
  }

  @PutMapping("/updateProducto")
  public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
    Producto productoActualizado = productoService.updateProducto(producto);
    return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
  }

  @DeleteMapping("/deleteProducto/{productoId}")
  @Transactional
  public ResponseEntity<Producto> deleteProductoById(@PathVariable("productoId") UUID id) {
    productoService.deleteProducto(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
