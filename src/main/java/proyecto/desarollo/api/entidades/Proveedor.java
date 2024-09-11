package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "proveedor")
public class Proveedor extends Persona implements Serializable {

  @NotBlank(message = "El campo no puede estar vacio")
  @Column(name = "codigo_proveedor", nullable = false, updatable = false)
  private String codigoProveedor;

  @NotBlank(message = "El campo de telefono no puede estar vacio")
  private String telefono;

  @NotBlank(message = "El campo de email no puede estar vacio")
  @Email(message = "Invalido formato de email")
  private String email;

  @NotBlank(message = "El nombre de la empresa no puede estar en blanco")
  @Column(name = "nombre_empresa")
  private String nombreEmpresa;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_rol", nullable = false)
  private Rol rol;
}
