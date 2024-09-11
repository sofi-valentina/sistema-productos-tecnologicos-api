package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.excepciones.UsuarioNotFoundException;
import proyecto.desarollo.api.entidades.Usuario;
import proyecto.desarollo.api.repositorios.UsuarioRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  @Autowired
  public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  public Usuario addUsuario(Usuario usuario) {
    usuario.setId(UUID.randomUUID());
    return usuarioRepository.save(usuario);
  }

  public List<Usuario> getAllUsuarios() {
    return usuarioRepository.findAll();
  }

  public Usuario getUsuarioById(UUID id) {
    return usuarioRepository
            .getUsuarioById(id)
            .orElseThrow(
                    () -> new UsuarioNotFoundException("Usuario con id " + id + " no encontrado")
            );
  }

  public Usuario updateUsuario(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  public void deleteUsuario(UUID id) {
    usuarioRepository.deleteById(id);
  }
}
