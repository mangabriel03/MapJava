package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.MerchandiseDto;
import map.project.myBand.Model.Merchandise;

public class MerchandiseAdapter implements Adapter<Merchandise, MerchandiseDto> {
    private static MerchandiseAdapter instance = null;

    public static MerchandiseAdapter getInstance(){
        if(instance == null){
            instance = new MerchandiseAdapter();
        }
        return instance;
    }
    @Override
    public MerchandiseDto adaptToDto(Merchandise object) {
        return new MerchandiseDto(object.getMerchandiseId(),
                object.getNumeProdus(),
                object.getStoc(),
                object.getPret());
    }
}
