package map.project.myBand.Model.Adapter;


import map.project.myBand.Model.Dto.ManagerDto;
import map.project.myBand.Model.Manager;

public class ManagerAdapter implements Adapter<Manager, ManagerDto> {
    private static ManagerAdapter instance = null;

    public static ManagerAdapter getInstance(){
        if(instance == null){
            instance = new ManagerAdapter();
        }
        return instance;
    }
    @Override
    public ManagerDto adaptToDto(Manager object) {
        return new ManagerDto(object.getManagerId(),
                object.getNume(),
                object.getPrenume());
    }
}
