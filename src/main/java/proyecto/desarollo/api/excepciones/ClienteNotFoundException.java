package proyecto.desarollo.api.excepciones;

public class ClienteNotFoundException extends RuntimeException {
  public ClienteNotFoundException(String message) {
    super(message);
  }
}
