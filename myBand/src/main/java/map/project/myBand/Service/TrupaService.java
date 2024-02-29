package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Repository.TrupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrupaService {
    @Autowired
    private TrupaRepository trupaRepository;

    public List<Trupa> findAll(){
        return trupaRepository.findAll();
    }

    public Trupa findTrupaById(Long trupaId) throws Exception {
        Optional<Trupa> trupa = this.trupaRepository.findByTrupaId(trupaId);
        if(trupa.isEmpty()){
            throw new Exception("There is no Trupa with this id");
        }
        else{
            return trupa.get();
        }
    }
    @Transactional
    public void deleteTrupa(Long trupaId) throws Exception{
        Optional<Trupa> trupa = this.trupaRepository.findByTrupaId(trupaId);
        if(trupa.isEmpty()){
            throw new Exception("There is no Trupa with this id");
        }
        else {
            this.trupaRepository.deleteByTrupaId(trupaId);
        }
    }

    public void addTrupa(Trupa trupa){
        this.trupaRepository.save(trupa);
    }
}
