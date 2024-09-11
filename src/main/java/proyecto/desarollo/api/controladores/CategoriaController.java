package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Categoria;
import proyecto.desarollo.api.servicios.CategoriaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {
  private final CategoriaService categoriaService;

  public CategoriaController(CategoriaService categoriaService) {
    this.categoriaService = categoriaService;
  }

  @GetMapping("/categorias")
  public ResponseEntity<List<Categoria>> getCategorias() {
    List<Categoria> categorias = categoriaService.getAllCategorias();
    return new ResponseEntity<>(categorias, HttpStatus.OK);
  }

  @GetMapping("/categorias/{categoriaId}")
  public ResponseEntity<Categoria> getCategoriaById(@PathVariable("categoriaId") UUID id) {
    Categoria categoria = categoriaService.getCategoriaById(id);
    return new ResponseEntity<>(categoria, HttpStatus.OK);
  }

  @PostMapping("/saveCategoria")
  public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
    Categoria categoriaCreada =  categoriaService.addCategoria(categoria);
    return new ResponseEntity<>(categoriaCreada, HttpStatus.CREATED);
  }

  @PutMapping("/updateCategoria")
  public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
    Categoria categoriaActualizada =  categoriaService.updateCategoria(categoria);
    return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
  }

  @DeleteMapping("/deleteCategoria/{categoriaId}")
  @Transactional
  public ResponseEntity<Categoria> deleteCategoriaById(@PathVariable("categoriaId") UUID id) {
    categoriaService.deleteCategoria(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
