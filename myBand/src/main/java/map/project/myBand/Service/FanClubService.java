package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.FanClub;
import map.project.myBand.Repository.FanClubRepository;
import map.project.myBand.Repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FanClubService {
    @Autowired
    private FanClubRepository fanClubRepository;

    public List<FanClub> findAllFanClubs(){
        return this.fanClubRepository.findAll();
    }
    @Transactional
    public FanClub findFanClubById(Long fanClubId) throws Exception {
        Optional<FanClub> fanClub = this.fanClubRepository.findByFanClubId(fanClubId);
        if(fanClub.isEmpty()){
            throw new Exception("There is no fan club with this id");
        }
        else{
            return fanClub.get();
        }
    }

    public void deleteFanClub(Long fanClubId) throws Exception{
        Optional<FanClub> fanClub = this.fanClubRepository.findByFanClubId(fanClubId);
        if(fanClub.isEmpty()){
            throw new Exception("There is no fan club with this id");
        }
        else {
            this.fanClubRepository.deleteByFanClubId(fanClubId);
        }
    }

    public void addFanClub(FanClub fanClub){
        this.fanClubRepository.save(fanClub);
    }
}
