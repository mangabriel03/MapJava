package map.project.myBand.Repository;

import map.project.myBand.Model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConcertRepository extends JpaRepository<Concert,Long> {

    Optional<Concert> findByConcertId(Long concertId);

    void deleteByConcertId(Long concertId);
}
