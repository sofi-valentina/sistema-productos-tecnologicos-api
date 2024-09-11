package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Rol;
import proyecto.desarollo.api.servicios.RolService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class RolController {
  private final RolService rolService;

  public RolController(RolService rolService) {
    this.rolService = rolService;
  }

  @GetMapping("/roles")
  public ResponseEntity<List<Rol>> getAllRoles() {
    List<Rol> roles = rolService.getAllRoles();
    return new ResponseEntity<>(roles, HttpStatus.OK);
  }

  @GetMapping("/roles/{rolId}")
  public ResponseEntity<Rol> getRolById(@PathVariable("rolId") UUID rolId) {
    Rol rol = rolService.getRolById(rolId);
    return new ResponseEntity<>(rol, HttpStatus.OK);
  }

  @PostMapping("/saveRol")
  public ResponseEntity<Rol> saveRol(@RequestBody Rol rol) {
    Rol rolCreado = rolService.addRol(rol);
    return new ResponseEntity<>(rolCreado, HttpStatus.CREATED);
  }

  @PutMapping("/updateRol")
  public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) {
    Rol rolActualizado = rolService.updateRol(rol);
    return new ResponseEntity<>(rolActualizado, HttpStatus.OK);
  }

  @DeleteMapping("/deleteRol/{rolId}")
  @Transactional
  public ResponseEntity<Void> deleteRolById(@PathVariable("rolId") UUID rolId) {
    rolService.deleteRol(rolId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
