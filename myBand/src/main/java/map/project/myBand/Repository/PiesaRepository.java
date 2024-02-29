package map.project.myBand.Repository;

import map.project.myBand.Model.Piesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PiesaRepository extends JpaRepository<Piesa , Long> {
    Optional<Piesa> findByPiesaId(Long piesaId);

    void deleteByPiesaId(Long piesaId);
}
