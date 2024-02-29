package map.project.myBand.UI;

import map.project.myBand.Model.Turneu;
import map.project.myBand.Service.TurneuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.Date;

@ShellComponent
public class TurneuCLI {
    @Autowired
    private TurneuService turneuService;

    @ShellMethod(key = "find turnee")
    public String findAllTurnee() {
        return turneuService.findAll().toString();
    }

    @ShellMethod(key = "add turneu")
    public String addTurneu(@ShellOption(value = {"nume"}) String nume,
                            @ShellOption(value = {"locatie"}) String locatie,
                            @ShellOption(value = {"data inceput"}) String dataInceput,
                            @ShellOption(value = {"data final"}) String dataFinal) {
        Turneu turneu = new Turneu();
        turneu.setNumeTurneu(nume);
        turneu.setLocatie(locatie);
        turneu.setDataInceput(Date.valueOf(dataInceput));
        turneu.setDataFinal(Date.valueOf(dataFinal));
        this.turneuService.addTurneu(turneu);
        return turneu.toString();
    }

    @ShellMethod(key = "update turneu")
    public String updateTurneu(@ShellOption(value = {"turneuId"}) Long turneuId,
                               @ShellOption(value = {"nume"}) String nume,
                               @ShellOption(value = {"locatie"}) String locatie,
                               @ShellOption(value = {"data inceput"}) String dataInceput,
                               @ShellOption(value = {"data final"}) String dataFinal) {
        try {
            Turneu turneu = this.turneuService.findTurneuById(turneuId);
            turneu.setNumeTurneu(nume);
            turneu.setLocatie(locatie);
            turneu.setDataInceput(Date.valueOf(dataInceput));
            turneu.setDataFinal(Date.valueOf(dataFinal));
            this.turneuService.addTurneu(turneu);
            return turneu.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete turneu")
    public String deleteTurneu(@ShellOption(value = {"turneu id"}) Long turneuId) {
        try {
            Turneu turneu = this.turneuService.findTurneuById(turneuId);
            this.turneuService.deleteTurneu(turneuId);
            return turneu.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
