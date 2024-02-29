package map.project.myBand.Repository;

import map.project.myBand.Model.Recenzie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecenzieRepository extends JpaRepository<Recenzie , Long> {
    Optional<Recenzie> findByRecenzieId(Long recenzieId);

    void deleteByRecenzieId(Long recenzieId);
}
