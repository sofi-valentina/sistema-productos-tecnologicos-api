package proyecto.desarollo.api.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compra")
public class Compra {
  @Id
  @Column(name = "id_compra", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String nombre;

  private String descripcion;

  @Temporal(TemporalType.TIMESTAMP)
  private Date fecha;

  private double costo;

//  @OneToMany
//  @JoinColumn(name = "id_producto")
//  private List<Producto> productos;
//
//  @ManyToOne
//  @JoinColumn(name = "id_proveedor")
//  private Proveedor proveedor;
}
