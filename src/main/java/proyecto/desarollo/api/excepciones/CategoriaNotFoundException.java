package proyecto.desarollo.api.excepciones;

public class CategoriaNotFoundException extends RuntimeException {
  public CategoriaNotFoundException(String message) {
    super(message);
  }
}
