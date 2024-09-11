package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta")
public class Venta {
  @Id
  @Column(name = "id_venta", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;
//  @ManyToOne
//  @JoinColumn(name = "id_cliente")
//  private Cliente cliente;
  private String descripcion;
//  @ManyToOne
//  @JoinColumn(name = "id_producto")
//  private Producto producto;
  private int cantidad;
  private double precioUnitario;
  private int estado;
}
