package map.project.myBand.Controller;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Dto.InstrumentDto;
import map.project.myBand.Model.Instrument;
import map.project.myBand.Service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {
    @Autowired
    private InstrumentService instrumentService;

    @GetMapping("/find-all")
    public List<InstrumentDto> findAll(){
        List<InstrumentDto> instrumentDtos = new ArrayList<>();
        for(Instrument instrument : this.instrumentService.findAllInstruments()){
            instrumentDtos.add((InstrumentDto) new DtoAdapterProxy().convertToDto(instrument));
        }
        return instrumentDtos;
    }

    @PostMapping("/add-instrument")
    public InstrumentDto addInstrument(@RequestParam String tipInstrument,
                                       @RequestParam String descriere){
        Instrument instrument = new Instrument();
        instrument.setTipInstrument(tipInstrument);
        instrument.setDescriere(descriere);
        return (InstrumentDto) new DtoAdapterProxy().convertToDto(instrument);
    }

    @PostMapping("/delete-instrument")
    public InstrumentDto deleteInstrument(@RequestParam Long instrumentId){
        try{
            Instrument instrument = this.instrumentService.findInstrumentById(instrumentId);
            this.instrumentService.deleteInstrument(instrumentId);
            return (InstrumentDto) new DtoAdapterProxy().convertToDto(instrument);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
