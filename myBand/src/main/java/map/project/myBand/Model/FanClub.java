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
public class FanClub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fanClubId;

    @ManyToOne
    @JoinColumn(name = "trupaId")
    private Trupa trupa;

    @Column(name = "nume")
    private String nume;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Fan> fan;

    @Override
    public String toString() {
        return "FanClub{" +
                "fanClubId=" + fanClubId +
                ", trupa=" + trupa +
                ", nume='" + nume + '\'' +
                '}';
    }
}
