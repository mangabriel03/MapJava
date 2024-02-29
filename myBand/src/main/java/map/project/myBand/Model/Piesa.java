package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Piesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long piesaId;

    @Column(name = "nume")
    private String nume;

    @Column(name = "durata")
    private float durata;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;

    @Override
    public String toString() {
        return "Piesa{" +
                "piesaId=" + piesaId +
                ", nume='" + nume + '\'' +
                ", durata=" + durata +
                '}';
    }
}
