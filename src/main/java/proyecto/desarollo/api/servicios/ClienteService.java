package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.excepciones.ClienteNotFoundException;
import proyecto.desarollo.api.entidades.Cliente;
import proyecto.desarollo.api.repositorios.ClienteRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {
  private final ClienteRepository clienteRepository;

  @Autowired
  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public Cliente addCliente(Cliente cliente) {
    cliente.setId(UUID.randomUUID());
    return clienteRepository.save(cliente);
  }

  public List<Cliente> getAllClientes() {
    return clienteRepository.findAll();
  }

  public Cliente getClienteById(UUID id) {
    return clienteRepository
            .getClienteById(id)
            .orElseThrow(
                    () -> new ClienteNotFoundException("Cliente con id " + " no encontrado")
            );
  }

  public Cliente updateCliente(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  public void deleteCliente(UUID id) {
    clienteRepository.deleteById(id);
  }
}
