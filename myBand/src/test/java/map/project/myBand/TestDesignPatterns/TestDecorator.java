package map.project.myBand.TestDesignPatterns;

import map.project.myBand.Model.Adapter.Proxy.DtoAdapterProxy;
import map.project.myBand.Model.Album;
import map.project.myBand.Model.Dto.Decorator.BandAlbumInformation;
import map.project.myBand.Model.Dto.Decorator.ConcreteAlbumInformation;
import map.project.myBand.Model.Dto.Decorator.FullAlbumInformation;
import map.project.myBand.Model.Recenzie;
import map.project.myBand.Model.Trupa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDecorator {
    Album album = new Album();
    Recenzie recenzie1 = new Recenzie();
    Recenzie recenzie2 = new Recenzie();

    Trupa trupa = new Trupa();

    public void initData(){
        album.setAlbumId(1L);
        album.setTitlu("Saraiman");
        album.setAnLansare(2003);
        album.setTrupa(trupa);

        trupa.setTrupaId(1L);
        trupa.setNume("Satra");
        trupa.setAnFormare(2001);

        recenzie1.setRecenzieId(1L);
        recenzie1.setRating(6);
        recenzie1.setAlbum(album);
        recenzie1.setTextRecenzie("cam nasol");

        recenzie2.setRecenzieId(2L);
        recenzie2.setRating(9);
        recenzie2.setAlbum(album);
        recenzie2.setTextRecenzie("cam sanky");

        List<Recenzie> recenzii = new ArrayList<>();
        recenzii.add(recenzie1);
        recenzii.add(recenzie2);

        album.setRecenzii(recenzii);
    }
    @Test
    public void testConcreteAlbumInformationDecorator(){
        initData();
        ConcreteAlbumInformation concreteAlbumInformation = new ConcreteAlbumInformation();
        Assertions.assertEquals(concreteAlbumInformation.showInformation(album) , new DtoAdapterProxy().convertToDto(album).toString());
    }

    @Test
    public void testBandAlbumInformationDecorator(){
        initData();
        ConcreteAlbumInformation concreteAlbumInformation = new ConcreteAlbumInformation();
        BandAlbumInformation bandAlbumInformation = new BandAlbumInformation(concreteAlbumInformation);

        System.out.println(bandAlbumInformation.showInformation(album));
        Assertions.assertEquals(bandAlbumInformation.showInformation(album),
                "AlbumDto{albumId=1, titlu='Saraiman', anLansare=2003}TrupaDto{trupaId=1, nume='Satra', anFormare=2001}");
    }
    @Test
    public void testAlbumFullInformation(){
        initData();
        ConcreteAlbumInformation concreteAlbumInformation = new ConcreteAlbumInformation();
        FullAlbumInformation fullAlbumInformation = new FullAlbumInformation(concreteAlbumInformation);

       Assertions.assertEquals(fullAlbumInformation.showInformation(album) ,
               "AlbumDto{albumId=1, titlu='Saraiman', anLansare=2003}[Recenzie{recenzieId=1, rating=6, textRecenzie='cam nasol'}," +
                       " Recenzie{recenzieId=2, rating=9, textRecenzie='cam sanky'}]");
    }
}
