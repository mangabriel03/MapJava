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
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long managerId;

    @Column(name = "nume")
    private String nume;

    @Column(name = "prenume")
    private String prenume;

    @OneToMany(mappedBy = "manager")
    private List<Trupa> trupe;

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
