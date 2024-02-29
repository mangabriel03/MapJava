package map.project.myBand.Repository;

import map.project.myBand.Model.Trupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrupaRepository extends JpaRepository<Trupa , Long> {
    Optional<Trupa> findByTrupaId(Long trupaId);

    void deleteByTrupaId(Long trupaId);
}
