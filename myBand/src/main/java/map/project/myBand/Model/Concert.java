package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long concertId;

    @Column(name = "data")
    private Date data;

    @Column(name = "nume")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "turneuId")
    private Turneu turneu;

    @ManyToOne
    @JoinColumn(name = "trupaId")
    Trupa trupa;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Instrument> instrumente;

    @Override
    public String toString() {
        return "Concert{" +
                "concertId=" + concertId +
                ", data=" + data +
                ", nume='" + nume + '\'' +
                '}';
    }
}
