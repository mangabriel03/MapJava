package map.project.myBand.UI;

import map.project.myBand.Model.FanClub;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Service.FanClubService;
import map.project.myBand.Service.TrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class FanCLubCLI {

    @Autowired
    private FanClubService fanClubService;

    @Autowired
    private TrupaService trupaService;

    @ShellMethod(key = "all clubs")
    public String findAllFanClubs() {
        return this.fanClubService.findAllFanClubs().toString();
    }
    @ShellMethod(key = "add club")
    public String addFanClub(@ShellOption(value = {"nume"}) String nume,
                             @ShellOption(value = {"trupa id"}) Long trupaId) {
        try {
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            FanClub fanClub = new FanClub();
            fanClub.setNume(nume);
            fanClub.setTrupa(trupa);
            this.fanClubService.addFanClub(fanClub);
            return fanClub.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete club")
    public String deleteFanClub(@ShellOption(value = {"fanclub id"}) Long fanClubId) {
        try {
            FanClub fanClub = this.fanClubService.findFanClubById(fanClubId);
            this.fanClubService.deleteFanClub(fanClubId);
           return fanClub.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod
    public String updateFanClub(@ShellOption(value = {"fanclub id"}) Long fanClubId,
                                @ShellOption(value = {"nume"}) String nume){
        try{
            FanClub fanClub = this.fanClubService.findFanClubById(fanClubId);
            fanClub.setNume(nume);
            this.fanClubService.addFanClub(fanClub);
            return fanClub.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
