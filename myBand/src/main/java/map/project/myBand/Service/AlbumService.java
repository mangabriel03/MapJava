package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Album;
import map.project.myBand.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAllAlbums(){
        return this.albumRepository.findAll();
    }

    public Album findAlbum(Long albumId) throws Exception {
        Optional<Album> albumOptional = this.albumRepository.findByAlbumId(albumId);
        if(albumOptional.isEmpty()){
            throw new Exception("there is no album with this id");
        }
        else{
            return albumOptional.get();
        }
    }
    @Transactional
    public Album deleteAlbum(Long albumId) throws Exception {
        Optional<Album> album = this.albumRepository.findByAlbumId(albumId);
        if(album.isEmpty()){
            throw new Exception("there is no album with this id");
        }
        else{
            this.albumRepository.deleteAlbumByAlbumId(albumId);
            return album.get();
        }
    }

    public void addAlbum(Album album){
        this.albumRepository.save(album);
    }
}
