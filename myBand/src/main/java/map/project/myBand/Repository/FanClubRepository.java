package map.project.myBand.Repository;

import map.project.myBand.Model.FanClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FanClubRepository extends JpaRepository<FanClub,Long> {
    Optional<FanClub> findByFanClubId(Long fanClubId);

    void deleteByFanClubId(Long fanClubId);
}
