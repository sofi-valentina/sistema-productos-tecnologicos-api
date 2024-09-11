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
@Table(name = "detalle_venta")
public class DetalleVenta {
  @Id
  @Column(name = "id_detalle_venta", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
//  @ManyToOne
//  @JoinColumn(name = "id_venta")
//  private Venta venta;
  private int estado;
}
