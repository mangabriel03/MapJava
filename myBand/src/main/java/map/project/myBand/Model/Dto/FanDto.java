package map.project.myBand.Model.Dto;

public class FanDto {

    private Long fanId;

    private String nume;

    private String prenume;

    public FanDto(Long fanId, String nume, String prenume) {
        this.fanId = fanId;
        this.nume = nume;
        this.prenume = prenume;
    }

    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "FanDto{" +
                "fanId=" + fanId +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
