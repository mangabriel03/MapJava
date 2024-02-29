package map.project.myBand.Controller;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Dto.FanDto;
import map.project.myBand.Model.Fan;
import map.project.myBand.Service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fan")
public class FanController {
    @Autowired
    private FanService fanService;

    @GetMapping("/find-all")
    public List<FanDto> findAllFans(){
        List<FanDto> fanDtoList = new ArrayList<>();
        for(Fan fan : this.fanService.findAllFans()){
            fanDtoList.add((FanDto) new DtoAdapterProxy().convertToDto(fan));
        }
        return fanDtoList;
    }

    @PostMapping("/add-fan")
    public FanDto addFan(@RequestParam String nume,
                         @RequestParam String prenume
                        ){
        Fan fan = new Fan();
        fan.setNume(nume);
        fan.setPrenume(prenume);
        this.fanService.addFan(fan);
        return (FanDto) new DtoAdapterProxy().convertToDto(fan);
    }

    @PostMapping("delete-fan")
    public FanDto deleteFan(@RequestParam Long fanId){
        try {
            Fan fan = this.fanService.findFanById(fanId);
            this.fanService.deleteFan(fanId);
            return (FanDto) new DtoAdapterProxy().convertToDto(fan);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("assign-fanClub")
    public FanDto assignFanCLub(@RequestParam Long fanId,
                                @RequestParam Long fanClubId){
        try{
            Fan fan = this.fanService.assignFanClub(fanId , fanClubId);
            return (FanDto) new DtoAdapterProxy().convertToDto(fan);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
