package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Piesa;
import map.project.myBand.Repository.PiesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiesaService {
    @Autowired
    private PiesaRepository piesaRepository;

    public List<Piesa> findAll(){
        return this.piesaRepository.findAll();
    }

    public Piesa findPiesaById(Long piesaId) throws Exception {
        Optional<Piesa> piesa = this.piesaRepository.findByPiesaId(piesaId);
        if(piesa.isEmpty()){
            throw new Exception("There is no Piesa with this id");
        }
        else{
            return piesa.get();
        }
    }
    @Transactional
    public void deletePiesa(Long piesaId) throws Exception {
        Optional<Piesa> piesa = this.piesaRepository.findByPiesaId(piesaId);
        if(piesa.isEmpty()){
            throw new Exception("There is no piesa with this id");
        }
        else{
            this.piesaRepository.deleteByPiesaId(piesaId);
        }
    }

    public void addPiesa(Piesa piesa){
        this.piesaRepository.save(piesa);
    }
}
