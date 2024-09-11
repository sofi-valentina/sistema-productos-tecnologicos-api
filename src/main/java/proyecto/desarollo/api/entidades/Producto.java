package proyecto.desarollo.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_producto", nullable = false, updatable = false)
  private UUID id;

  @Column(unique = true)
  @NotNull(message = "El nombre no puede estar vacio")
  @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
  private String nombre;

  @NotNull(message = "El precio no puede ser nulo")
  @Positive(message = "El precio debe ser un número positivo")
  private Double precio;

  @Min(value = 0, message = "El estado no puede ser negativo")
  @Max(value = 1, message = "El estado solo puede ser 0 o 1")
  private int estado;

  @Min(value = 0, message = "La cantidad no puede ser negativa")
  private int cantidad;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_categoria")
  @JsonIgnore()
  private Categoria categoria;
}
