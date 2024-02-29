package map.project.myBand.Model.Dto.Decorator;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Album;

public class ConcreteAlbumInformation implements AlbumInformation{
    @Override
    public String showInformation(Album album) {
        return new DtoAdapterProxy().convertToDto(album).toString();
    }
}
