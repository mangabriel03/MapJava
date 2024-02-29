package map.project.myBand.UI;

import map.project.myBand.Model.Manager;
import map.project.myBand.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class ManagerCLI {

    @Autowired
    private ManagerService managerService;

    @ShellMethod(key = "all managers")
    public String findAllManagers(){
        return this.managerService.findAllManagers().toString();
    }

    @ShellMethod(key = "add manager")
    public String addManager(@ShellOption(value = {"nume"}) String nume,
                             @ShellOption(value = {"prenume"}) String prenume){
        Manager manager = new Manager();
        manager.setNume(nume);
        manager.setPrenume(prenume);
        this.managerService.addManager(manager);
        return manager.toString();
    }
    @ShellMethod(key = "delete manager")
    public String deleteManager(@ShellOption(value = {"manager id"})Long managerId){
        try {
            Manager manager = this.managerService.findManagerById(managerId);
            this.managerService.deleteManager(managerId);
            return manager.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

}
