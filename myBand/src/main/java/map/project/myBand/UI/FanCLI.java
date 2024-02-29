package map.project.myBand.UI;

import map.project.myBand.Model.Fan;
import map.project.myBand.Service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class FanCLI {
    @Autowired
    private FanService fanService;

    @ShellMethod(key = "all fans")
    public String findAllFans(){
        return this.fanService.findAllFans().toString();
    }
    //todo breaks
    @ShellMethod(key = "add fan")
    public String addFan(@ShellOption(value = {"nume"})String nume,
                         @ShellOption(value = {"prenume"}) String prenume) {
        Fan fan = new Fan();
        fan.setPrenume(prenume);
        fan.setIsHyped(0);
        fan.setNume(nume);
        this.fanService.addFan(fan);
        return fan.toString();
    }

    @ShellMethod(key = "delete fan")
    public String deleteFan(@ShellOption(value = {"fan id"}) Long fanId){
        try{
            Fan fan = this.fanService.findFanById(fanId);
            this.fanService.deleteFan(fanId);
            return fan.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "assign fan club")
    public String assignFanClub(@ShellOption(value = {"fan id"}) Long fanId,
                                @ShellOption(value = {"fan club id"}) Long fanClubId){
        try{
            Fan fan = this.fanService.assignFanClub(fanId , fanClubId);
            return fan.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
