package map.project.myBand.UI;

import map.project.myBand.Model.Album;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Service.AlbumService;
import map.project.myBand.Service.TrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AlbumCLI {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrupaService trupaService;

    @ShellMethod(key = "find albums" ,value = "find albums")
    public String findAllAlbums(){
        return this.albumService.findAllAlbums().toString();
    }

    @ShellMethod(key = "add album")
    public String addAlbum(@ShellOption(value = "titlu") String titlu,
                           @ShellOption(value = "an lansare") int anLansare,
                           @ShellOption(value = "id trupa") Long trupaId){
        try{
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            Album album = new Album();
            album.setTitlu(titlu);
            album.setAnLansare(anLansare);
            album.setTrupa(trupa);
            this.albumService.addAlbum(album);
            return album.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete album")
    public String deleteAlbum(@ShellOption(value = {"id album"}) Long albumId){
        try {
            Album album = this.albumService.deleteAlbum(albumId);
            return album.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update album")
    public String updateAlbum(@ShellOption(value = {"id album"}) Long albumId,
                              @ShellOption(value = {"titlu"}) String titlu){
        try{
            Album album = this.albumService.findAlbum(albumId);
            album.setTitlu(titlu);
            this.albumService.addAlbum(album);
            return album.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
