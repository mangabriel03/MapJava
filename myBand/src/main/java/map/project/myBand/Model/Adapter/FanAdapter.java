package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.FanDto;
import map.project.myBand.Model.Fan;

public class FanAdapter implements Adapter<Fan, FanDto> {
    private static FanAdapter instance= null;

    public static FanAdapter getInstance(){
        if(instance == null){
            instance = new FanAdapter();
        }
        return instance;
    }
    @Override
    public FanDto adaptToDto(Fan object) {
        return new FanDto(object.getFanId(),
                object.getNume(),
                object.getPrenume());
    }
}
