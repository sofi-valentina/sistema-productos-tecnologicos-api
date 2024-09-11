package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "usuario")
public class Usuario extends Persona implements Serializable {

  @NotBlank(message = "Algunos de los campos se encuentra en blanco")
  private String username;

  @NotBlank(message = "Algunos de los campos se encuentra en blanco")
  private String password;

  @Min(value = 0, message = "El estado no puede ser negativo")
  @Max(value = 1, message = "El estado solo puede ser 0 o 1")
  private int estado;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_rol", nullable = false)
  private Rol rol;
}
