package co.com.banco.personas.jpa.cliente;

import co.com.banco.personas.jpa.persona.PersonaData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cliente")
public class ClienteData {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "contrasenna", nullable = false)
    private String contrasenna;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @OneToOne
    @JoinColumn(name="persona_id")
    private PersonaData persona;
}
