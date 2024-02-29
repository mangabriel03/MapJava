package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Model.Turneu;
import map.project.myBand.Repository.TrupaRepository;
import map.project.myBand.Repository.TurneuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurneuService {
    @Autowired
    private TurneuRepository turneuRepository;

    public List<Turneu> findAll(){
        return this.turneuRepository.findAll();
    }

    public Turneu findTurneuById(Long turneuId) throws Exception {
        Optional<Turneu> turneu = this.turneuRepository.findByTurneuId(turneuId);
        if(turneu.isEmpty()){
            throw new Exception("There is no Turneu with this Id");
        }
        else {
            return turneu.get();
        }
    }
@Transactional
    public void deleteTurneu(Long turneuId) throws Exception{
        Optional<Turneu> turneu = this.turneuRepository.findByTurneuId(turneuId);
        if(turneu.isEmpty()){
            throw new Exception("There is no Turneu with this id");
        }
        else {
            this.turneuRepository.deleteByTurneuId(turneuId);
        }
    }

    public void addTurneu(Turneu turneu){
        this.turneuRepository.save(turneu);
    }
}
