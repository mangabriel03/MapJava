package map.project.myBand.Repository;

import map.project.myBand.Model.Merchandise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise,Long> {
    Optional<Merchandise> findMerchandiseByMerchandiseId(Long merchandiseId);

    void deleteByMerchandiseId(Long merchandiseId);
}
