package proyecto.desarollo.api.entidades;

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
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable {

  @NotBlank(message = "El campo no puede estar vacio")
  @Column(name = "codigo_cliente")
  private String codigoCliente;

  @PositiveOrZero(message = "El CI debe ser positivo o 0")
  private int ci;

  @PositiveOrZero(message = "El CI debe ser positivo o 0")
  private int nit;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_rol", nullable = false)
  private Rol rol;
}
