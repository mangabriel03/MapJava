package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.FanClubDto;
import map.project.myBand.Model.FanClub;

public class FanClubAdapter implements Adapter<FanClub, FanClubDto> {
    private static FanClubAdapter instance = null;

    public static FanClubAdapter getInstance(){
        if(instance == null){
            instance = new FanClubAdapter();
        }
        return instance;
    }
    @Override
    public FanClubDto adaptToDto(FanClub object) {
        return new FanClubDto(object.getFanClubId(),
                object.getNume());
    }
}
