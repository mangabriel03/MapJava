package map.project.myBand.UI;

import map.project.myBand.Model.Concert;
import map.project.myBand.Model.Manager;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Service.ConcertService;
import map.project.myBand.Service.ManagerService;
import map.project.myBand.Service.TrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class TrupaCLI {
    @Autowired
    private TrupaService trupaService;

    @Autowired
    private ConcertService concertService;
    @Autowired
    private ManagerService managerService;

    @ShellMethod(key = "all trupe")
    public String findAllTrupe() {
        return this.trupaService.findAll().toString();
    }

    @ShellMethod(key = "add trupa")
    public String addTrupa(@ShellOption(value = {"nume"}) String nume,
                           @ShellOption(value = {"an formare"}) int an,
                           @ShellOption(value = {"manager id"}) Long managerId) {
        try {
            Manager manager = this.managerService.findManagerById(managerId);
            Trupa trupa = new Trupa();
            trupa.setAnFormare(an);
            trupa.setNume(nume);
            trupa.setManager(manager);
            this.trupaService.addTrupa(trupa);
            return trupa.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update trupa")
    public String updateTrupa(@ShellOption(value = {"trupa id"}) Long trupaId,
                              @ShellOption(value = {"nume"}) String nume,
                              @ShellOption(value = {"manager id"}) Long managerId) {
        try {
            Manager manager = this.managerService.findManagerById(managerId);
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            trupa.setNume(nume);
            trupa.setManager(manager);
            this.trupaService.addTrupa(trupa);
            return trupa.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @ShellMethod(value = "delete trupa")
    public String deleteTrupa(@ShellOption(value = {"trupa id"}) Long trupaId){
        try {
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            this.trupaService.deleteTrupa(trupaId);
            return trupa.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
