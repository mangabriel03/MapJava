package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.RecenzieDto;
import map.project.myBand.Model.Recenzie;

public class RecenzieAdapter implements Adapter<Recenzie, RecenzieDto> {
    private static RecenzieAdapter instance = null;

    public static RecenzieAdapter getInstance(){
        if(instance == null){
            instance = new RecenzieAdapter();
        }
        return instance;
    }
    @Override
    public RecenzieDto adaptToDto(Recenzie object) {
        return new RecenzieDto(object.getRecenzieId(),
                object.getRating(),
                object.getTextRecenzie());
    }
}
