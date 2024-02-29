package map.project.myBand.Model.Adapter.Proxy;

import map.project.myBand.Model.*;
import map.project.myBand.Model.Adapter.*;

import java.lang.reflect.Type;

/**
 * proxy design pattern
 */
public class DtoAdapterProxy implements AdapterProxy{
    @Override
    public Object convertToDto(Object object) {
        if(object.getClass() == Album.class){
            return AlbumAdapter.getInstance().adaptToDto((Album) object);
        }
        if(object.getClass() == Concert.class){
            return ConcertAdapter.getInstance().adaptToDto((Concert) object);
        }
        if(object.getClass() == Fan.class){
            return FanAdapter.getInstance().adaptToDto((Fan) object);
        }
        if(object.getClass() == FanClub.class){
            return FanClubAdapter.getInstance().adaptToDto((FanClub) object);
        }
        if(object.getClass() == Instrument.class){
            return InstrumentAdapter.getInstance().adaptToDto((Instrument) object);
        }
        if(object.getClass() == Manager.class){
            return ManagerAdapter.getInstance().adaptToDto((Manager) object);
        }
        if(object.getClass() == Merchandise.class){
            return MerchandiseAdapter.getInstance().adaptToDto((Merchandise) object);
        }
        if(object.getClass() == Piesa.class){
            return PiesaAdapter.getInstance().adaptToDto((Piesa) object);
        }
        if(object.getClass() == Recenzie.class){
            return RecenzieAdapter.getInstance().adaptToDto((Recenzie) object);
        }
        if(object.getClass() == Trupa.class){
            return TrupaAdapter.getInstance().adaptToDto((Trupa) object);
        }
        if(object.getClass() == Turneu.class){
            return TurneuAdapter.getInstance().adaptToDto((Turneu) object);
        }
        return null;
    }
}
