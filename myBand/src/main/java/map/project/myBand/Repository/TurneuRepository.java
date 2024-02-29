package map.project.myBand.Repository;

import map.project.myBand.Model.Turneu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurneuRepository extends JpaRepository<Turneu , Long> {
    Optional<Turneu> findByTurneuId(Long turneuId);

    void deleteByTurneuId(Long turneuId);
}
