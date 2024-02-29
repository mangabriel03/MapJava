package map.project.myBand.Model.Dto;

import java.sql.Date;

public class TurneuDto {
    private Long turneuId;

    private String nume;

    private String locatie;

    private Date start;

    private Date end;

    public TurneuDto(Long turneuId, String nume, String locatie, Date start, Date end) {
        this.turneuId = turneuId;
        this.nume = nume;
        this.locatie = locatie;
        this.start = start;
        this.end = end;
    }

    public Long getTurneuId() {
        return turneuId;
    }

    public void setTurneuId(Long turneuId) {
        this.turneuId = turneuId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TurneuDto{" +
                "turneuId=" + turneuId +
                ", nume='" + nume + '\'' +
                ", locatie='" + locatie + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
