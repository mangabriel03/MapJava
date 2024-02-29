package map.project.myBand.TestDesignPatterns;

import map.project.myBand.Model.*;
import map.project.myBand.Model.Adapter.*;
import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class TestProxyPattern {
    public DtoAdapterProxy dtoAdapterProxy = new DtoAdapterProxy();
    @Test
    public void testAlbumProxy(){
        Album album = new Album();
        album.setAlbumId(1L);
        album.setTitlu("epic new album");
        album.setAnLansare(1998);

        AlbumDto albumDto =(AlbumDto) dtoAdapterProxy.convertToDto(album);
        Assertions.assertEquals(albumDto.getAlbumId(), album.getAlbumId());
        Assertions.assertEquals(albumDto.getTitlu() , album.getTitlu());
        Assertions.assertEquals(albumDto.getAnLansare() , album.getAnLansare());
    }
    @Test
    public void testConcertProxy(){
        Concert concert = new Concert();
        concert.setConcertId(1L);
        concert.setData(Date.valueOf("2023-11-11"));
        concert.setNume("Mimi");

        ConcertDto concertDto =(ConcertDto) dtoAdapterProxy.convertToDto(concert);

        assertEquals(concertDto.getConcertId() , concert.getConcertId());
        assertEquals(concertDto.getData() , concert.getData());
        assertEquals(concertDto.getNume() , concert.getNume());
    }
    @Test
    public void testFanAdapter(){
        Fan fan = new Fan();
        fan.setFanId(1L);
        fan.setNume("Calciuc");
        fan.setPrenume("Mugurel");

        FanDto fanDto = (FanDto) dtoAdapterProxy.convertToDto(fan);

        assertEquals(fanDto.getFanId() , fan.getFanId());
        assertEquals(fanDto.getNume() , fan.getNume());
        assertEquals(fanDto.getPrenume() , fan.getPrenume());
    }

    @Test
    public void testFanClubAdapter(){
        FanClub fanClub = new FanClub();
        fanClub.setNume("Marginarii");
        fanClub.setFanClubId(1L);

        FanClubDto fanClubDto = (FanClubDto) dtoAdapterProxy.convertToDto(fanClub);

        assertEquals(fanClubDto.getFanClubId() , fanClub.getFanClubId());
        assertEquals(fanClubDto.getNume() , fanClub.getNume());
    }
    @Test
    public void testInstrumentAdapter(){
        Instrument instrument = new Instrument();

        instrument.setInstrumentId(1L);
        instrument.setTipInstrument("suflat");
        instrument.setDescriere("Cel mai smecher pregatar");

        InstrumentDto instrumentDto = (InstrumentDto) dtoAdapterProxy.convertToDto(instrument);

        assertEquals(instrumentDto.getInstrumentId() , instrument.getInstrumentId());
        assertEquals(instrumentDto.getTipInstrument() , instrument.getTipInstrument());
        assertEquals(instrumentDto.getDescriere() , instrument.getDescriere());
    }
    @Test
    public void testManagerAdapter(){
        Manager manager = new Manager();

        manager.setManagerId(1L);
        manager.setNume("Marin");
        manager.setPrenume("Preda");

        ManagerDto managerDto = (ManagerDto) dtoAdapterProxy.convertToDto(manager);

        assertEquals(managerDto.getManagerId() , manager.getManagerId());
        assertEquals(managerDto.getNume() , manager.getNume());
        assertEquals(managerDto.getPrenume() , manager.getPrenume());
    }
    @Test
    public void testMechandiseAdapter(){
        Merchandise merchandise = new Merchandise();
        merchandise.setMerchandiseId(1L);
        merchandise.setPret(100);
        merchandise.setStoc(100);
        merchandise.setNumeProdus("Tricou stas");

        MerchandiseDto merchandiseDto = (MerchandiseDto) dtoAdapterProxy.convertToDto(merchandise);

        assertEquals(merchandiseDto.getMerchId() , merchandise.getMerchandiseId());
        assertEquals(merchandiseDto.getPret() , merchandise.getPret());
        assertEquals(merchandiseDto.getStoc() , merchandise.getStoc());
        assertEquals(merchandiseDto.getNumeProdus() , merchandise.getNumeProdus());
    }

    @Test
    public void testPiesaAdapter(){
        Piesa piesa = new Piesa();
        piesa.setPiesaId(1L);
        piesa.setNume("Ma simt ca Mbappe");
        piesa.setDurata(3);

        PiesaDto piesaDto = (PiesaDto) dtoAdapterProxy.convertToDto(piesa);

        assertEquals(piesaDto.getPiesaId() , piesa.getPiesaId());
        assertEquals(piesaDto.getNume() , piesa.getNume());
        assertEquals(piesaDto.getDurata() , piesa.getDurata() , 0.0);
    }
    @Test
    public void testRecezieAdapter(){
        Recenzie recenzie = new Recenzie();
        recenzie.setRecenzieId(1L);
        recenzie.setRating(7);
        recenzie.setTextRecenzie("Decent se putea mai bine gheboasa fa mai bine");

        RecenzieDto recenzieDto = (RecenzieDto) dtoAdapterProxy.convertToDto(recenzie);

        assertEquals(recenzieDto.getRecenzieId() , recenzie.getRecenzieId());
        assertEquals(recenzieDto.getRating() , recenzie.getRating());
        assertEquals(recenzieDto.getText() , recenzie.getTextRecenzie());
    }
    @Test
    public void testTrupaAdapter(){
        Trupa trupa = new Trupa();
        trupa.setTrupaId(1L);
        trupa.setNume("Satra Benz");
        trupa.setAnFormare(2003);

        TrupaDto trupaDto = (TrupaDto) dtoAdapterProxy.convertToDto(trupa);

        assertEquals(trupaDto.getTrupaId() , trupa.getTrupaId());
        assertEquals(trupaDto.getNume() , trupa.getNume());
        assertEquals(trupaDto.getAnFormare() , trupa.getAnFormare());
    }

    @Test
    public void testTurneuAdapter(){
        Turneu turneu = new Turneu();
        turneu.setTurneuId(1L);
        turneu.setLocatie("Acasa");
        turneu.setNumeTurneu("Satra Benz");
        turneu.setDataInceput(Date.valueOf("2023-11-11"));
        turneu.setDataFinal(Date.valueOf("2023-11-11"));

        TurneuDto turneuDto = (TurneuDto) dtoAdapterProxy.convertToDto(turneu);

        assertEquals(turneuDto.getTurneuId() , turneu.getTurneuId());
        assertEquals(turneuDto.getNume() , turneu.getNumeTurneu());
        assertEquals(turneuDto.getLocatie() , turneu.getLocatie());
        assertEquals(turneuDto.getStart() , turneu.getDataInceput());
        assertEquals(turneuDto.getEnd() , turneu.getDataFinal());
    }
}
