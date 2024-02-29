package map.project.myBand.Model.Dto;

public class PiesaDto {
    private Long piesaId;

    private String nume;

    private float durata;

    public PiesaDto(Long piesaId, String nume, float durata) {
        this.piesaId = piesaId;
        this.nume = nume;
        this.durata = durata;
    }

    public Long getPiesaId() {
        return piesaId;
    }

    public void setPiesaId(Long piesaId) {
        this.piesaId = piesaId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "PiesaDto{" +
                "piesaId=" + piesaId +
                ", nume='" + nume + '\'' +
                ", durata=" + durata +
                '}';
    }
}
