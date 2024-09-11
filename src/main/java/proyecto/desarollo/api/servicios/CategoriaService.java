package proyecto.desarollo.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.desarollo.api.excepciones.CategoriaNotFoundException;
import proyecto.desarollo.api.entidades.Categoria;
import proyecto.desarollo.api.repositorios.CategoriaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
  private final CategoriaRepository categoriaRepository;

  @Autowired
  public CategoriaService(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  public Categoria addCategoria(Categoria categoria) {
    categoria.setId(UUID.randomUUID());
    return categoriaRepository.save(categoria);
  }

  public List<Categoria> getAllCategorias() {
    return categoriaRepository.findAll();
  }

  public Categoria getCategoriaById(UUID id) {
    return categoriaRepository
            .findCategoriaById(id)
            .orElseThrow(
                    () -> new CategoriaNotFoundException("Categoria con id " + id + " no encontrado")
            );
  }

  public Categoria updateCategoria(Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  public void deleteCategoria(UUID id) {
    categoriaRepository.deleteCategoriaById(id);
  }
}
