package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long albumId;

    @Column(name = "titlu")
    private String titlu;

    @Column(name = "an lansare")
    private int anLansare;

    @ManyToOne
    @JoinColumn(name = "trupaId")
    private Trupa trupa;


    @OneToMany(mappedBy = "album")
    private List<Piesa> piese;

    @OneToMany(mappedBy = "album")
    private List<Recenzie> recenzii;

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", titlu='" + titlu + '\'' +
                ", anLansare=" + anLansare +
                '}';
    }

}
