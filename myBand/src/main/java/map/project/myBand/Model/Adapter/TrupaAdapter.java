package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.TrupaDto;
import map.project.myBand.Model.Trupa;

public class TrupaAdapter implements Adapter<Trupa, TrupaDto> {
    private static TrupaAdapter instance = null;

    public static TrupaAdapter getInstance(){
        if(instance == null){
            instance = new TrupaAdapter();
        }
        return instance;
    }
    @Override
    public TrupaDto adaptToDto(Trupa object) {
        return new TrupaDto(object.getTrupaId(),
                object.getNume(),
                object.getAnFormare());
    }
}
