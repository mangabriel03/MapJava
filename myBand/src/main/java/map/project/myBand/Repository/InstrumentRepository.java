package map.project.myBand.Repository;

import map.project.myBand.Model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InstrumentRepository extends JpaRepository<Instrument,Long> {
    Optional<Instrument> findInstrumentByInstrumentId(Long instrumentId);

    void deleteByInstrumentId(Long instrumentId);
}
