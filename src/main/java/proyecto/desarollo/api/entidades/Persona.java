package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Persona {
  @Id
  @Column(name = "id_persona", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "El nombre no puede estar en blanco")
  private String nombre;

  @NotBlank(message = "El apellido paterno no puede estar vacio")
  @Column(name = "apellido_paterno")
  private String apellidoPaterno;

  @Column(name = "apellido_materno")
  private String apellidoMaterno;

  @NotBlank(message = "El genero no puede estar vacio")
  private String genero;
}
