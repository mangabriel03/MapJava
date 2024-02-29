package map.project.myBand.Model.Dto.Decorator;

import map.project.myBand.Model.Album;

public class FullAlbumInformation   extends AlbumInformationDecorator{
    public FullAlbumInformation(AlbumInformation albumInformation){
        super(albumInformation);
    }

    public String showInformation(Album album){
        return super.showInformation(album) + this.showAlbumRecenzie(album);
    }

    private String showAlbumRecenzie(Album album){
        return album.getRecenzii().toString();
    }
}
