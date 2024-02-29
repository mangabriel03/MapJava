package map.project.myBand.Model.Dto;

public class ManagerDto {
    private Long managerId;

    private String nume;

    private String prenume;

    public ManagerDto(Long managerId, String nume, String prenume) {
        this.managerId = managerId;
        this.nume = nume;
        this.prenume = prenume;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
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
        return "ManagerDto{" +
                "managerId=" + managerId +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
