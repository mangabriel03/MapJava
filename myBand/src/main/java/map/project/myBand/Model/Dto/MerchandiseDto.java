package map.project.myBand.Model.Dto;

public class MerchandiseDto {
    private Long merchId;

    private String numeProdus;

    private int stoc;

    private int pret;

    public MerchandiseDto(Long merchId, String numeProdus, int stoc, int pret) {
        this.merchId = merchId;
        this.numeProdus = numeProdus;
        this.stoc = stoc;
        this.pret = pret;
    }

    public Long getMerchId() {
        return merchId;
    }

    public void setMerchId(Long merchId) {
        this.merchId = merchId;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "merchId=" + merchId +
                ", numeProdus='" + numeProdus + '\'' +
                ", stoc=" + stoc +
                ", pret=" + pret +
                '}';
    }
}
