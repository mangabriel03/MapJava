package map.project.myBand.Controller;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Album;
import map.project.myBand.Model.Dto.AlbumDto;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Service.AlbumService;
import map.project.myBand.Service.TrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/album") //localhost:8080/album
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrupaService trupaService;

    @GetMapping("/find-all") //localhost:8080/album/find-all
    public List<AlbumDto> findAllAlbum() {
        List<AlbumDto> albumDtoList = new ArrayList<>();
        DtoAdapterProxy proxy = new DtoAdapterProxy();
        for (Album album : this.albumService.findAllAlbums()) {
            albumDtoList.add((AlbumDto) proxy.convertToDto(album));
        }
        return albumDtoList;
    }

    @PostMapping("/add-album")
    public AlbumDto addAlbum(
            @RequestParam String titlu,
            @RequestParam int anLansare,
            @RequestParam Long trupaId) {
        try {
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            Album album = new Album();
            album.setTitlu(titlu);
            album.setAnLansare(anLansare);
            album.setTrupa(trupa);
            this.albumService.addAlbum(album);
            return (AlbumDto) new DtoAdapterProxy().convertToDto(album);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-album")
    public AlbumDto deleteAlbum(@RequestParam Long albumId){
        try{
            Album album = this.albumService.deleteAlbum(albumId);
            return (AlbumDto) new DtoAdapterProxy().convertToDto(album);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-album")
    public AlbumDto updateAlbum(@RequestParam Long albumId,
                                @RequestParam String titlu){
        try{
            Album album = this.albumService.findAlbum(albumId);
            album.setTitlu(titlu);
            this.albumService.addAlbum(album);
            return (AlbumDto) new DtoAdapterProxy().convertToDto(album);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
