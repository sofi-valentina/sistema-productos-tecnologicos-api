package proyecto.desarollo.api.excepciones;

public class RolNotFoundException extends RuntimeException {
  public RolNotFoundException(String message) {
    super(message);
  }
}
