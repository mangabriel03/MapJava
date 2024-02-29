package map.project.myBand.Controller;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Concert;
import map.project.myBand.Model.Dto.ConcertDto;
import map.project.myBand.Model.Turneu;
import map.project.myBand.Service.ConcertService;
import map.project.myBand.Service.TurneuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/concert")
public class ConcertController {
    @Autowired
    private ConcertService concertService;
    @Autowired
    private TurneuService turneuService;

    @GetMapping("/find-all")
    public List<ConcertDto> findConcerts(){
        List<ConcertDto> concertDtos = new ArrayList<>();
        for( Concert concert : this.concertService.findAllConcerts()){
            concertDtos.add((ConcertDto) new DtoAdapterProxy().convertToDto(concert));
        }
        return concertDtos;
    }

    @PostMapping("/add-concert")
    public ConcertDto addConcert(@RequestParam String data,
                                 @RequestParam String nume,
                                 @RequestParam Long turneuId){
        try{
            Turneu turneu = this.turneuService.findTurneuById(turneuId);
            Concert concert = new Concert();
            concert.setNume(nume);
            concert.setTurneu(turneu);
            concert.setData(Date.valueOf(data));
            this.concertService.addConcert(concert);
            return (ConcertDto) new DtoAdapterProxy().convertToDto(concert);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-concert")
    public ConcertDto deleteConcert(@RequestParam Long concertId){
        try{
            Concert concert = this.concertService.findConcert(concertId);
            this.concertService.deleteConcert(concertId);
            return (ConcertDto) new DtoAdapterProxy().convertToDto(concert);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-concert")
    public ConcertDto updateConcert(@RequestParam Long concertId,
                                    @RequestParam String nume,
                                    @RequestParam String data){
        try{
            Concert concert = this.concertService.findConcert(concertId);
            concert.setData(Date.valueOf(data));
            concert.setNume(nume);
            this.concertService.addConcert(concert);
            return (ConcertDto) new DtoAdapterProxy().convertToDto(concert);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
