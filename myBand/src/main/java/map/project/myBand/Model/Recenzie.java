package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Recenzie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recenzieId;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;

    @Column(name = "rating")
    private int rating;

    @Column(name = "text recenzie")
    private String textRecenzie;

    @Override
    public String toString() {
        return "Recenzie{" +
                "recenzieId=" + recenzieId +
                ", rating=" + rating +
                ", textRecenzie='" + textRecenzie + '\'' +
                '}';
    }
}
