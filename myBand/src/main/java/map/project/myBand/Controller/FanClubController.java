package map.project.myBand.Controller;

import map.project.myBand.Model.Adapter.FanClubAdapter;
import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Dto.FanClubDto;
import map.project.myBand.Model.Fan;
import map.project.myBand.Model.FanClub;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Service.FanClubService;
import map.project.myBand.Service.TrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fan-club")
public class FanClubController {
    @Autowired
    private FanClubService fanClubService;

    @Autowired
    private TrupaService trupaService;

    @GetMapping("/find-all")
    public List<FanClubDto> findAll() {
        List<FanClubDto> fanClubDtos = new ArrayList<>();
        for (FanClub fanClub : this.fanClubService.findAllFanClubs()) {
            fanClubDtos.add((FanClubDto) new DtoAdapterProxy().convertToDto(fanClub));
        }
        return fanClubDtos;
    }

    @PostMapping("/add-fan-club")
    public FanClubDto addFanClub(@RequestParam String nume,
                                 @RequestParam Long trupaId) {
        try {
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            FanClub fanClub = new FanClub();
            fanClub.setTrupa(trupa);
            fanClub.setNume(nume);
            this.fanClubService.addFanClub(fanClub);
            return (FanClubDto) new DtoAdapterProxy().convertToDto(fanClub);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-fan-club")
    public FanClubDto deleteFanClub(@RequestParam Long fanClubId) {
        try {
            FanClub fanClub = this.fanClubService.findFanClubById(fanClubId);
            return (FanClubDto) new DtoAdapterProxy().convertToDto(fanClub);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-fan-club")
    public FanClubDto updateFanClub(@RequestParam Long fanClubId,
                                    @RequestParam String name) {
        try{
            FanClub fanClub = this.fanClubService.findFanClubById(fanClubId);
            this.fanClubService.deleteFanClub(fanClubId);
            return (FanClubDto) new DtoAdapterProxy().convertToDto(fanClub);
        }
        catch (Exception e ){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
