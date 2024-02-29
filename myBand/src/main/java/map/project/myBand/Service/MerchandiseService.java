package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Merchandise;
import map.project.myBand.Repository.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchandiseService {
    @Autowired
    private MerchandiseRepository merchandiseRepository;

    public List<Merchandise> findAllMerch(){
        return this.merchandiseRepository.findAll();
    }

    public Merchandise addMerch(Merchandise merchandise){
        this.merchandiseRepository.save(merchandise);
        return merchandise;
    }

    public Merchandise findMerch(Long merchId) throws Exception {
        Optional<Merchandise> merchandise = this.merchandiseRepository.findMerchandiseByMerchandiseId(merchId);
        if(merchandise.isEmpty()){
            throw new Exception("There is no merch with this id");
        }
        return merchandise.get();
    }
    @Transactional
    public Merchandise deleteMerch(Long merchId) throws  Exception{
        Optional<Merchandise> merchandise = this.merchandiseRepository.findMerchandiseByMerchandiseId(merchId);
        if(merchandise.isEmpty()){
            throw new Exception("There is no merch with this id");
        }
        this.merchandiseRepository.deleteByMerchandiseId(merchId);
        return merchandise.get();
    }

    public Merchandise makeDiscountById(Long merchId , int discount) throws Exception {
        Optional<Merchandise> merchandise = this.merchandiseRepository.findMerchandiseByMerchandiseId(merchId);
        if(merchandise.isEmpty()){
            throw new Exception("There is no merch with this id");
        }
        merchandise.get().discount(discount);
        return merchandise.get();
    }
}
