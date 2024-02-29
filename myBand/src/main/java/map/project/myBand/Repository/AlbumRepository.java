package map.project.myBand.Repository;

import map.project.myBand.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    Optional<Album> findByAlbumId(Long albumId);

    void deleteAlbumByAlbumId(Long albumId);

}
