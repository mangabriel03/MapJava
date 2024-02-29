package map.project.myBand.Model.Dto.Decorator;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Album;

public class BandAlbumInformation extends AlbumInformationDecorator{
    public BandAlbumInformation(AlbumInformation albumInformation) {
        super(albumInformation);
    }

    public String showInformation(Album album){
        return super.showInformation(album) + this.bandInformation(album);
    }

    private String bandInformation(Album album){
        return new DtoAdapterProxy().convertToDto(album.getTrupa()).toString();
    }
}
