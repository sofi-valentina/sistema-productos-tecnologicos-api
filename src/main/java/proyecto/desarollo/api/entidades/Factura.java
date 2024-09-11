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
@Table(name = "factura")
public class Factura {
  @Id
  @Column(name = "id_factura", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
//  @OneToOne
//  @JoinColumn(name = "id_venta")
//  private Venta venta;
  private double total;
  @Temporal(TemporalType.DATE)
  private Date fechaExpiracion;
  private int estado;
}
