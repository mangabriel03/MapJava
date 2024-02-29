package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Turneu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long turneuId;

    @Column(name = "nume trupa")
    private String numeTurneu;

    @Column(name = "locatie")
    private String locatie;

    @Column(name = "data inceput")
    private Date dataInceput;

    @Column(name = "data final")
    private Date dataFinal;

    @OneToMany(mappedBy = "turneu")
    List<Concert> concerte;

    @Override
    public String toString() {
        return "Turneu{" +
                "turneuId=" + turneuId +
                ", numeTrupa='" + numeTurneu + '\'' +
                ", locatie='" + locatie + '\'' +
                ", dataInceput=" + dataInceput +
                ", dataFinal=" + dataFinal +
                '}';
    }
}
