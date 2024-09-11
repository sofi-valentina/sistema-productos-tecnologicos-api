package proyecto.desarollo.api.controladores;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.desarollo.api.entidades.Cliente;
import proyecto.desarollo.api.servicios.ClienteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ClienteController {
  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping("/clientes")
  public ResponseEntity<List<Cliente>> getAllClientes() {
    List<Cliente> clientes = clienteService.getAllClientes();
    return new ResponseEntity<>(clientes, HttpStatus.OK);
  }

  @GetMapping("/clientes/{clienteId}")
  public ResponseEntity<Cliente> getClienteById(@PathVariable("clienteId") UUID clienteId) {
    Cliente cliente = clienteService.getClienteById(clienteId);
    return new ResponseEntity<>(cliente, HttpStatus.OK);
  }

  @PostMapping("/saveCliente")
  public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
    Cliente clienteCreado = clienteService.addCliente(cliente);
    return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
  }

  @PutMapping("/updateCliente")
  public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
    Cliente clienteActualizado = clienteService.updateCliente(cliente);
    return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
  }

  @DeleteMapping("/deleteCliente/{clienteId}")
  @Transactional
  public ResponseEntity<Void> deleteClienteById(@PathVariable("clienteId") UUID clienteId) {
    clienteService.deleteCliente(clienteId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
