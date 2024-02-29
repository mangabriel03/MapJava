package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Recenzie;
import map.project.myBand.Repository.RecenzieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzieService {
    @Autowired
    private RecenzieRepository recenzieRepository;

    public List<Recenzie> findAll(){
        return this.recenzieRepository.findAll();
    }

    public Recenzie findRecenzieById(Long recenzieId) throws Exception {
        Optional<Recenzie> recenzie =this.recenzieRepository.findByRecenzieId(recenzieId);
        if(recenzie.isEmpty()){
            throw  new Exception("There is no Recenzie with this id");
        }
        else {
            return recenzie.get();
        }
    }
    @Transactional
    public void deleteRecenzie(Long recenzieId) throws Exception{
        Optional<Recenzie> recenzieOptional = this.recenzieRepository.findByRecenzieId(recenzieId);
        if(recenzieOptional.isEmpty()){
            throw new Exception("There is no Recenzie with this id");
        }
        else{
            this.recenzieRepository.deleteByRecenzieId(recenzieId);
        }
    }

    public void addRecenzie(Recenzie recenzie){
        this.recenzieRepository.save(recenzie);
    }

}
