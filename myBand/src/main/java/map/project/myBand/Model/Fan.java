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
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fanId;

    @Column(name = "nume")
    private String nume;

    @Column(name  = "prenume")
    private String prenume;

    @ManyToMany(fetch = FetchType.EAGER)
    List<FanClub> fanClubs;

    @Column(name = "isyped" )
    private int isHyped =0;

    @Override
    public String toString() {
        return "Fan{" +
                "fanId=" + fanId +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }

    /**
     * observer pattern cand fanii sunt anuntati de discount
     */
    public void updateHype(){
        this.isHyped = 1;
    }

    public int isHyped() {
        return isHyped;
    }

}
