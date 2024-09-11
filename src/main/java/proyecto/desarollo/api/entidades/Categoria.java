package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_categoria", nullable = false, updatable = false)
  private UUID id;

  @NotNull(message = "El nombre no puede ser nulo")
  @Column(unique = true)
  private String nombre;

  @NotNull(message = "La garantia no puede ser nula")
  @Positive(message = "La garantia debe ser un número positivo")
  private int garantia;

  @OneToMany(mappedBy = "categoria")
  private List<Producto> productos;
}
