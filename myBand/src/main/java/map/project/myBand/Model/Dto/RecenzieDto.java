package map.project.myBand.Model.Dto;

public class RecenzieDto {

    private Long recenzieId;

    private int rating;

    private String text;

    public RecenzieDto(Long recenzieId, int rating, String text) {
        this.recenzieId = recenzieId;
        this.rating = rating;
        this.text = text;
    }

    public Long getRecenzieId() {
        return recenzieId;
    }

    public void setRecenzieId(Long recenzieId) {
        this.recenzieId = recenzieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RecenzieDto{" +
                "recenzieId=" + recenzieId +
                ", rating=" + rating +
                ", text='" + text + '\'' +
                '}';
    }
}
