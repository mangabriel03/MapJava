package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.InstrumentDto;
import map.project.myBand.Model.Instrument;

public class InstrumentAdapter implements Adapter<Instrument, InstrumentDto> {
    private static InstrumentAdapter instance = null;

    public static InstrumentAdapter getInstance(){
        if(instance == null){
            instance = new InstrumentAdapter();
        }
        return instance;
    }
    @Override
    public InstrumentDto adaptToDto(Instrument object) {
        return new InstrumentDto(object.getInstrumentId(),
                object.getTipInstrument(),
                object.getDescriere());
    }
}
