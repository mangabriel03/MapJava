package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long instrumentId;

    @Column(name = "tip instrument")
    private String tipInstrument;

    @Column(name = "descriere")
    private String descriere;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Concert> concerte;

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentId=" + instrumentId +
                ", tipInstrument='" + tipInstrument + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
