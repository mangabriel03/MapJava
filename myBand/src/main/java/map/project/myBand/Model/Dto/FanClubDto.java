package map.project.myBand.Model.Dto;

public class FanClubDto {

    private Long fanClubId;

    private String nume;

    public FanClubDto(Long fanClubId, String nume) {
        this.fanClubId = fanClubId;
        this.nume = nume;
    }

    public Long getFanClubId() {
        return fanClubId;
    }

    public void setFanClubId(Long fanClubId) {
        this.fanClubId = fanClubId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "FanClubDto{" +
                "fanClubId=" + fanClubId +
                ", nume='" + nume + '\'' +
                '}';
    }
}
