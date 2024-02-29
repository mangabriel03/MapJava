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
public class Trupa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trupaId;

    @Column(name = "nume")
    private String nume;

    @Column(name = "an formare")
    private int anFormare;

    @OneToMany(mappedBy = "trupa" )
    private List<Concert> concerts;

    @ManyToOne
    @JoinColumn(name = "managerId")
    private Manager manager;

    @OneToMany(mappedBy = "trupa")
    private List<FanClub> fanClub;

    @OneToMany(mappedBy = "trupa")
    private List<Merchandise> merchandises;

    @OneToMany(mappedBy = "trupa")
    private List<Album> albume;

    @Override
    public String toString() {
        return "Trupa{" +
                "trupaId=" + trupaId +
                ", nume='" + nume + '\'' +
                ", anFormare=" + anFormare +
                '}';
    }
}
