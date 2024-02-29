package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Concert;
import map.project.myBand.Repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {
    @Autowired
    private ConcertRepository concertRepository;

    public List<Concert> findAllConcerts(){
        return this.concertRepository.findAll();
    }

    public Concert findConcert(Long concertId) throws Exception {
        Optional<Concert> concert = this.concertRepository.findByConcertId(concertId);

        if(concert.isEmpty()){
            throw  new Exception("there is no concert with this id");
        }
        else{
            return concert.get();
        }
    }
    @Transactional
    public void deleteConcert(Long concertId) throws Exception {
        Optional<Concert> concert = this.concertRepository.findByConcertId(concertId);
        if(concert.isEmpty()){
            throw new Exception("There is no concert with this id");
        }
        else{
            this.concertRepository.deleteByConcertId(concertId);
        }
    }

    public void addConcert(Concert concert){
        this.concertRepository.save(concert);
    }
}
