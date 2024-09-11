package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {
  @Id
  @Column(name = "id_detalle_compra", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private double precioUnitario;
  private double precioTotal;
  private int cantidad;
  private int estado;

//  @ManyToOne
//  @JoinColumn(name = "id_compra")
//  private Compra compra;
}
