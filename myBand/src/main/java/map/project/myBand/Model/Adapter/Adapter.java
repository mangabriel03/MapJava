package map.project.myBand.Model.Adapter;

public interface Adapter<T , S> {

    S adaptToDto(T object);

}
