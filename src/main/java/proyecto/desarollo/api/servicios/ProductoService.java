package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.excepciones.CategoriaNotFoundException;
import proyecto.desarollo.api.excepciones.ProductoNotFoundException;
import proyecto.desarollo.api.entidades.Categoria;
import proyecto.desarollo.api.entidades.Producto;
import proyecto.desarollo.api.repositorios.CategoriaRepository;
import proyecto.desarollo.api.repositorios.ProductoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductoService {
  private final ProductoRepository productoRepository;
  private final CategoriaRepository categoriaRepository;

  @Autowired
  public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
    this.productoRepository = productoRepository;
    this.categoriaRepository = categoriaRepository;
  }

  public Producto addProducto(Producto producto) {
    producto.setId(UUID.randomUUID());
    return productoRepository.save(producto);
  }

  public List<Producto> getAllProductos() {
    return productoRepository.findAll();
  }

  public Producto getProductoById(UUID id) {
    return productoRepository
            .findProductoById(id)
            .orElseThrow(
                    () -> new ProductoNotFoundException("Producto con id " + id + " no se encontro")
            );
  }

  public Producto getProductoByNombre(String name) {
    return productoRepository
            .findProductoByNombre(name)
            .orElseThrow(
                    () -> new ProductoNotFoundException("Producto with name " + name + " was not found")
            );
  }

  public Producto updateProducto(Producto producto) {
    return productoRepository.save(producto);
  }

  public void deleteProducto(UUID id) {
    productoRepository.deleteProductoById(id);
  }
}
