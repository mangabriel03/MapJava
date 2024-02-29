package map.project.myBand.UI;

import map.project.myBand.Model.Concert;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Model.Turneu;
import map.project.myBand.Service.ConcertService;
import map.project.myBand.Service.TrupaService;
import map.project.myBand.Service.TurneuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.Date;

@ShellComponent
public class ConcertCLI {
    @Autowired
    private ConcertService concertService;

    @Autowired
    private TurneuService turneuService;

    @Autowired
    private TrupaService trupaService;

    @ShellMethod(key= {"all concerts"})
    public String findAllConcerts(){
        return this.concertService.findAllConcerts().toString();
    }

    @ShellMethod(key = "add concert")
    public String addConcert(@ShellOption(value = {"nume"}) String nume,
                             @ShellOption(value = {"data"} )String data,
                             @ShellOption(value = {"id turneu"}) Long turneuId,
                             @ShellOption(value = {"id trupa"}) Long trupaId)
    {
        try{
            Turneu turneu = this.turneuService.findTurneuById(turneuId);
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            Concert concert = new Concert();
            concert.setNume(nume);
            concert.setData(Date.valueOf(data));
            concert.setTurneu(turneu);
            concert.setTrupa(trupa);
            this.concertService.addConcert(concert);
            return concert.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete concert")
    public String deleteConcert(@ShellOption(value = {"id concert"}) Long concertId){
        try{
            Concert concert = this.concertService.findConcert(concertId);
            this.concertService.deleteConcert(concertId);
            return concert.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update concert")
    public String updateConcert(@ShellOption(value = {"id concert"}) Long concertId,
                                @ShellOption(value = {"data"}) String data,
                                @ShellOption(value = {"nume"}) String nume,
                                @ShellOption(value = {"trupa id"}) Long trupaId){
        try{
            Concert concert = this.concertService.findConcert(concertId);
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            concert.setNume(nume);
            concert.setTrupa(trupa);
            concert.setData(Date.valueOf(data));
            this.concertService.addConcert(concert);
            return concert.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
