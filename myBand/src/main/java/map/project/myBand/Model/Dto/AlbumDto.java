package map.project.myBand.Model.Dto;

public class AlbumDto {

    private Long albumId;

    private String titlu;

    private int anLansare;

    public AlbumDto(Long albumId, String titlu, int anLansare) {
        this.albumId = albumId;
        this.titlu = titlu;
        this.anLansare = anLansare;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    @Override
    public String toString() {
        return "AlbumDto{" +
                "albumId=" + albumId +
                ", titlu='" + titlu + '\'' +
                ", anLansare=" + anLansare +
                '}';
    }
}
