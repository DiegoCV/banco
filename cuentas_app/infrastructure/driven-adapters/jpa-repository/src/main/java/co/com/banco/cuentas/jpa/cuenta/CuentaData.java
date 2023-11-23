package co.com.banco.cuentas.jpa.cuenta;

import co.com.banco.cuentas.jpa.movimiento.MovimientoData;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cuenta")
@Builder
public class CuentaData {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @Column(name = "cliente_id", nullable = false)
    private UUID clienteID;
}
