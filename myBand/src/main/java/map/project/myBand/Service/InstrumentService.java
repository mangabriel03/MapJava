package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Concert;
import map.project.myBand.Model.Instrument;
import map.project.myBand.Repository.ConcertRepository;
import map.project.myBand.Repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentService {
    @Autowired
    private InstrumentRepository instrumentRepository;

    @Autowired
    private ConcertRepository concertRepository;

    public List<Instrument> findAllInstruments(){
        return this.instrumentRepository.findAll();
    }

    public Instrument findInstrumentById(Long instrumentId) throws Exception {
        Optional<Instrument> instrument = this.instrumentRepository.findInstrumentByInstrumentId(instrumentId);
        if(instrument.isEmpty()){
            throw new Exception("There is no instrument with this id");
        }
        else{
            return instrument.get();
        }
    }
    @Transactional
    public void deleteInstrument(Long instrumentId) throws Exception{
        Optional<Instrument> instrument = this.instrumentRepository.findInstrumentByInstrumentId(instrumentId);
        if(instrument.isEmpty()){
            throw new Exception("There is no instrument with this id");
        }
        else {
            this.instrumentRepository.deleteByInstrumentId(instrumentId);
        }
    }

    public void addInstrument(Instrument instrument){
        this.instrumentRepository.save(instrument);
    }

    public Instrument assingInstrumentToConcert(Long instrumentId , Long concertId) throws Exception {
        Optional<Instrument> instrument = this.instrumentRepository.findInstrumentByInstrumentId(instrumentId);
        Optional<Concert> concert = this.concertRepository.findByConcertId(concertId);

        if(instrument.isEmpty()){
            throw new Exception("There is no instrument with this id");
        }

        if(concert.isEmpty()){
            throw new Exception("There is no concert with this id");
        }

        List<Concert> concerts = instrument.get().getConcerte();
        List<Instrument> instruments = concert.get().getInstrumente();

        concerts.add(concert.get());
        instruments.add(instrument.get());
        concert.get().setInstrumente(instruments);
        instrument.get().setConcerte(concerts);
        this.instrumentRepository.save(instrument.get());
        return instrument.get();
    }
}
