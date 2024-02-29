package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.PiesaDto;
import map.project.myBand.Model.Piesa;

public class PiesaAdapter implements Adapter<Piesa, PiesaDto> {

    private static PiesaAdapter instance = null;

    public static PiesaAdapter getInstance(){
        if(instance == null){
            instance = new PiesaAdapter();
        }
        return instance;
    }
    @Override
    public PiesaDto adaptToDto(Piesa object) {
        return new PiesaDto(object.getPiesaId(),
                object.getNume(),
                object.getDurata());
    }
}
