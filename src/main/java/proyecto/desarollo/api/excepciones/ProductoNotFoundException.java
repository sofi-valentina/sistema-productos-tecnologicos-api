package proyecto.desarollo.api.excepciones;

public class ProductoNotFoundException extends RuntimeException {
  public ProductoNotFoundException(String message) {
    super(message);
  }
}
