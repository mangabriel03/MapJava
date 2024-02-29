package map.project.myBand.Model.Dto;

public class TrupaDto {
    private Long trupaId;

    private String nume;

    private int anFormare;

    public TrupaDto(Long trupaId, String nume, int anFormare) {
        this.trupaId = trupaId;
        this.nume = nume;
        this.anFormare = anFormare;
    }

    public Long getTrupaId() {
        return trupaId;
    }

    public void setTrupaId(Long trupaId) {
        this.trupaId = trupaId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getAnFormare() {
        return anFormare;
    }

    public void setAnFormare(int anFormare) {
        this.anFormare = anFormare;
    }

    @Override
    public String toString() {
        return "TrupaDto{" +
                "trupaId=" + trupaId +
                ", nume='" + nume + '\'' +
                ", anFormare=" + anFormare +
                '}';
    }
}
