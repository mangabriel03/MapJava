package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Album;
import map.project.myBand.Model.Dto.AlbumDto;
import map.project.myBand.Service.AlbumService;
import org.springframework.stereotype.Service;

public class AlbumAdapter implements Adapter<Album, AlbumDto> {

    private static AlbumAdapter instance = null;

    /**
     * singleton
     * @return
     */
    public static AlbumAdapter getInstance(){
        if(instance == null){
            instance = new AlbumAdapter();
        }
        return instance;
    }
    @Override
    public AlbumDto adaptToDto(Album object) {
        return new AlbumDto(object.getAlbumId(),
                object.getTitlu(),
                object.getAnLansare()
                );
    }

}
