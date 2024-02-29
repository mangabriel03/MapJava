package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.TrupaDto;
import map.project.myBand.Model.Dto.TurneuDto;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Model.Turneu;

public class TurneuAdapter implements Adapter<Turneu, TurneuDto> {

    private static TurneuAdapter instance = null;
    public static TurneuAdapter getInstance(){
        if(instance == null){
            instance = new TurneuAdapter();
        }
        return instance;
    }
    @Override
    public TurneuDto adaptToDto(Turneu object) {
        return new TurneuDto(object.getTurneuId(),
                object.getNumeTurneu(),
                object.getLocatie(),
                object.getDataInceput(),
                object.getDataInceput());
    }
}
