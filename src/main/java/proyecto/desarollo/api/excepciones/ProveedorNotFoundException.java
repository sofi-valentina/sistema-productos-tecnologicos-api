package proyecto.desarollo.api.excepciones;

public class ProveedorNotFoundException extends RuntimeException {
  public ProveedorNotFoundException(String message) {
    super(message);
  }
}
