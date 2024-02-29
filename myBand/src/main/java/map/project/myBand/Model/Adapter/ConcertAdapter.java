package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Concert;
import map.project.myBand.Model.Dto.ConcertDto;

public class ConcertAdapter implements Adapter<Concert, ConcertDto> {
    private static ConcertAdapter instance = null;

    public static ConcertAdapter getInstance(){
        if(instance == null){
            instance = new ConcertAdapter();
        }
        return instance;
    }
    @Override
    public ConcertDto adaptToDto(Concert object) {
        return new ConcertDto(object.getConcertId(),
                object.getData(),
                object.getNume());
    }
}
