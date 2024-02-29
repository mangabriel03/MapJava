package map.project.myBand.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.TreePath;

@Data
@Setter
@Getter
@Entity
public class Merchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long merchandiseId;

    @Column(name = "nume produs")
    private String numeProdus;

    @Column(name = "stoc")
    private int stoc;

    @Column(name = "pret")
    private int pret;

    @ManyToOne
    @JoinColumn(name = "trupaId")
    private Trupa trupa;

    @Override
    public String toString() {
        return "Merchandise{" +
                "merchandiseId=" + merchandiseId +
                ", numeProdus='" + numeProdus + '\'' +
                ", stoc=" + stoc +
                ", pret=" + pret +
                '}';
    }

    /**
     * observer design pattern o sa anuntam oamenii din fanclub cand exista
     * o reducere la Merch
     */
    public void discount(int discountAmount){
        this.pret = this.pret * (100-discountAmount)/100;
        for (FanClub fanClub : this.trupa.getFanClub()){
            for (Fan fan : fanClub.getFan()){
                fan.updateHype();
            }
        }
    }
}
