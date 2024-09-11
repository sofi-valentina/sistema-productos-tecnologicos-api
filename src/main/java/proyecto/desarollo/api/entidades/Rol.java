package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "rol")
public class Rol implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id_rol", nullable = false, updatable = false)
  private UUID id;

  @NotBlank(message = "El nombre no puede estar en blanco")
  @Column(unique = true)
  private String nombre;

  @Min(value = 0, message = "El estado no puede ser negativo")
  @Max(value = 1, message = "El estado solo puede ser 0 o 1")
  private int estado;

  @OneToMany(mappedBy = "rol")
  private List<Cliente> clientes;

  @OneToMany(mappedBy = "rol")
  private List<Proveedor> proveedores;

  @OneToMany(mappedBy = "rol")
  private List<Usuario> usuarios;
}
