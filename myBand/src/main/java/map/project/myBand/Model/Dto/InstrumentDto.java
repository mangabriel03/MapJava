package map.project.myBand.Model.Dto;

public class InstrumentDto {
    private Long instrumentId;

    private String tipInstrument;

    private String descriere;

    public InstrumentDto(Long instrumentId, String tipInstrument, String descriere) {
        this.instrumentId = instrumentId;
        this.tipInstrument = tipInstrument;
        this.descriere = descriere;
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getTipInstrument() {
        return tipInstrument;
    }

    public void setTipInstrument(String tipInstrument) {
        this.tipInstrument = tipInstrument;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "InstrumentDto{" +
                "instrumentId=" + instrumentId +
                ", tipInstrument='" + tipInstrument + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
