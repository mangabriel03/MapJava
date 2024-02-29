package map.project.myBand.UI;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Album;
import map.project.myBand.Model.Piesa;
import map.project.myBand.Service.AlbumService;
import map.project.myBand.Service.PiesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class PiesaCLI {
    @Autowired
    private PiesaService piesaService;

    @Autowired
    private AlbumService albumService;

    @ShellMethod(key = "all piese")
    public String findAll() {
        return this.piesaService.findAll().toString();
    }

    @ShellMethod(key = "add piesa")
    public String addPiesa(@ShellOption(value = {"nume"}) String nume,
                           @ShellOption(value = {"durata"}) float durata,
                           @ShellOption(value = {"album id"}) Long albumId) {
        try {
            Album album = this.albumService.findAlbum(albumId);
            Piesa piesa = new Piesa();
            piesa.setDurata(durata);
            piesa.setAlbum(album);
            piesa.setNume(nume);
            this.piesaService.addPiesa(piesa);
            return piesa.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @ShellMethod(key = "delete piesa")
    public String deletePiesa(@ShellOption(value = {"piesa id"}) Long piesaId) {
        try {
            Piesa piesa = this.piesaService.findPiesaById(piesaId);
            this.piesaService.deletePiesa(piesaId);
            return piesa.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update piesa")
    public String updatePiesa(@ShellOption(value = {"piesa id"}) Long piesaId,
                              @ShellOption(value = {"nume"}) String nume) {
        try {
            Piesa piesa = this.piesaService.findPiesaById(piesaId);
            piesa.setNume(nume);
            this.piesaService.addPiesa(piesa);
            return piesa.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
