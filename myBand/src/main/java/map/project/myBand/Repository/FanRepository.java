package map.project.myBand.Repository;

import map.project.myBand.Model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FanRepository extends JpaRepository<Fan , Long> {
    Optional<Fan> findByFanId(Long fanId);

    void deleteByFanId(Long fanId);
}
