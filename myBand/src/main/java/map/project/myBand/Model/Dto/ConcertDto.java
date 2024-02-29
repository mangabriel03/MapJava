package map.project.myBand.Model.Dto;

import java.sql.Date;

public class ConcertDto {

    private Long concertId;

    private Date data;

    private String nume;

    public ConcertDto(Long concertId, Date data, String nume) {
        this.concertId = concertId;
        this.data = data;
        this.nume = nume;
    }

    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "ConcertDto{" +
                "concertId=" + concertId +
                ", data=" + data +
                ", nume='" + nume + '\'' +
                '}';
    }
}
