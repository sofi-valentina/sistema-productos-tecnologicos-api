package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Usuario;
import proyecto.desarollo.api.servicios.UsuarioService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class UsuarioController {
  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping("/usuarios")
  public ResponseEntity<List<Usuario>> getAllUsuarios() {
    List<Usuario> usuarios = usuarioService.getAllUsuarios();
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
  }

  @GetMapping("/usuarios/{usuarioId}")
  public ResponseEntity<Usuario> getUsuarioById(@PathVariable("usuarioId") UUID usuarioId) {
    Usuario usuario = usuarioService.getUsuarioById(usuarioId);
    return new ResponseEntity<>(usuario, HttpStatus.OK);
  }

  @PostMapping("/saveUsuario")
  public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
    Usuario usuarioCreado = usuarioService.addUsuario(usuario);
    return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
  }

  @PutMapping("/updateUsuario")
  public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
    Usuario usuarioActualizado = usuarioService.updateUsuario(usuario);
    return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
  }

  @DeleteMapping("/deleteUsuario/{usuarioId}")
  @Transactional
  public ResponseEntity<Void> deleteUsuarioById(@PathVariable("usuarioId") UUID usuarioId) {
    usuarioService.deleteUsuario(usuarioId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
