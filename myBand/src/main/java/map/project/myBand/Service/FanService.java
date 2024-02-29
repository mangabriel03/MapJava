package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Fan;
import map.project.myBand.Model.FanClub;
import map.project.myBand.Repository.FanClubRepository;
import map.project.myBand.Repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FanService {
    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private FanClubRepository fanClubRepository;

    public List<Fan> findAllFans(){
        return this.fanRepository.findAll();
    }

    public Fan findFanById(Long fanId) throws Exception {
        Optional<Fan> fanOptional = this.fanRepository.findByFanId(fanId);

        if(fanOptional.isEmpty()){
            throw new Exception("There is no fan with this id");
        }
        else{
            return fanOptional.get();
        }
    }
    @Transactional
    public void deleteFan(Long fanId) throws Exception {
        Optional<Fan> fan = this.fanRepository.findByFanId(fanId);
        if(fan.isEmpty()){
            throw new Exception("There is no fan with this id");
        }
        else{
            this.fanRepository.deleteByFanId(fanId);
        }
    }

    public void addFan(Fan fan){
        this.fanRepository.save(fan);
    }

    public Fan assignFanClub(Long fanId , Long fanClubId) throws Exception {
        Optional<Fan> fan = this.fanRepository.findByFanId(fanId);
        Optional<FanClub> fanClub = this. fanClubRepository.findByFanClubId(fanClubId);
        if(fan.isEmpty()){
            throw new Exception("There is no fan with this id");
        }

        if(fanClub.isEmpty()){
            throw new Exception("There is no fanClub with this id");
        }

        List<FanClub> fanClubs = fan.get().getFanClubs();
        fanClubs.add(fanClub.get());
        List<Fan> fans = fanClub.get().getFan();
        fans.add(fan.get());
        this.fanRepository.save(fan.get());
        this.fanClubRepository.save(fanClub.get());
        return fan.get();
    }
}
