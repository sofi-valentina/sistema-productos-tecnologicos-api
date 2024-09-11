package proyecto.desarollo.api.excepciones;

public class UsuarioNotFoundException extends RuntimeException {
  public UsuarioNotFoundException(String message) {
    super(message);
  }
}
