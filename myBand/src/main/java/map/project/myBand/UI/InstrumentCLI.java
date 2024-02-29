package map.project.myBand.UI;

import map.project.myBand.Model.Instrument;
import map.project.myBand.Service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class InstrumentCLI {

    @Autowired
    private InstrumentService instrumentService;

    @ShellMethod(key = "all instruments")
    public String findAllInstruments(){
        return this.instrumentService.findAllInstruments().toString();
    }

    @ShellMethod(key = "add instrument")
    public String addInstrument(@ShellOption(value = {"tip instrument"}) String tipInstrument,
                                @ShellOption(value = {"descriere"}) String descriere){
        Instrument instrument = new Instrument();
        instrument.setTipInstrument(tipInstrument);
        instrument.setDescriere(descriere);
        this.instrumentService.addInstrument(instrument);
        return instrument.toString();
    }

    @ShellMethod(key = "delete instrument")
    public String deleteInstrument(@ShellOption(value = {"instrument id"}) Long instrumentId){
        try{
            Instrument instrument = this.instrumentService.findInstrumentById(instrumentId);
            this.instrumentService.deleteInstrument(instrumentId);
            return instrument.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    //todo breaks
    @ShellMethod(key = "assign to concert")
    public String assignInstrumentToConcert(@ShellOption(value = "concert id") Long concertId,
                                            @ShellOption(value = "instrument id") Long instrumentId){
        try{
           Instrument instrument =  this.instrumentService.assingInstrumentToConcert(instrumentId , concertId);
           return instrument.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
