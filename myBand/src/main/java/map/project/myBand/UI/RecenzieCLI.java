package map.project.myBand.UI;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Album;
import map.project.myBand.Model.Recenzie;
import map.project.myBand.Service.AlbumService;
import map.project.myBand.Service.RecenzieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class RecenzieCLI {

    @Autowired
    private RecenzieService recenzieService;

    @Autowired
    private AlbumService albumService;

    @ShellMethod(key = "all recenzii")
    public String findAllRecenzii(){
        return this.recenzieService.findAll().toString();
    }

    @ShellMethod(key = "add recenzie")
    public String addRecenzie(@ShellOption(value = {"rating"}) int rating,
                              @ShellOption(value = {"text"}) String text,
                              @ShellOption(value = {"album id"}) Long albumId){
        try{
            Album album = this.albumService.findAlbum(albumId);
            Recenzie recenzie = new Recenzie();
            recenzie.setTextRecenzie(text);
            recenzie.setAlbum(album);
            recenzie.setAlbum(album);
            this.recenzieService.addRecenzie(recenzie);
            return recenzie.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update recenzie")
    public String updateRecenzie(@ShellOption(value = {"recenzie id"}) Long recenzieId,
                                 @ShellOption(value = {"text"}) String text,
                                 @ShellOption(value = {"rating"}) int rating){
        try{
            Recenzie recenzie = this.recenzieService.findRecenzieById(recenzieId);
            recenzie.setTextRecenzie(text);
            recenzie.setRating(rating);
            this.recenzieService.addRecenzie(recenzie);
            return recenzie.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    @ShellMethod(key = "delete recenzie")
    public String deleteRecenzie(@ShellOption(value = {"recezie id"}) Long recenzieId){
        try {
            Recenzie recenzie = this.recenzieService.findRecenzieById(recenzieId);
            this.recenzieService.deleteRecenzie(recenzieId);
            return recenzie.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
