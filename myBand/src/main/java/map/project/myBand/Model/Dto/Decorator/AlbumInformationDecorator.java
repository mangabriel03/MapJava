package map.project.myBand.Model.Dto.Decorator;

import map.project.myBand.Model.Album;

public abstract class AlbumInformationDecorator implements AlbumInformation{

    private AlbumInformation albumInformation;

    public AlbumInformationDecorator(AlbumInformation albumInformation) {
        this.albumInformation = albumInformation;
    }

    @Override
    public  String showInformation(Album album){
        return albumInformation.showInformation(album);
    }
}
