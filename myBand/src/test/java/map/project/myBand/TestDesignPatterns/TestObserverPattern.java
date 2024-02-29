package map.project.myBand.TestDesignPatterns;

import map.project.myBand.Model.Fan;
import map.project.myBand.Model.FanClub;
import map.project.myBand.Model.Merchandise;
import map.project.myBand.Model.Trupa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class TestObserverPattern {
    @Test
    public void TestObserverPattern(){
        Merchandise merchandise = new Merchandise();
        FanClub fanClub1 = new FanClub();
        FanClub fanClub2 = new FanClub();
        Trupa trupa = new Trupa();
        List<FanClub> fanClubList = new ArrayList<>();
        fanClubList.add(fanClub1);
        fanClubList.add(fanClub2);

        fanClub1.setFanClubId(1L);
        fanClub1.setTrupa(trupa);
        fanClub2.setFanClubId(2L);
        fanClub2.setTrupa(trupa);

        trupa.setTrupaId(1L);
        trupa.setNume("Maneskin");
        trupa.setFanClub(fanClubList);


        Fan fan1 = new Fan();
        fan1.setFanId(1L);
        fan1.setIsHyped(0);
        Fan fan2 = new Fan();
        fan2.setFanId(2L);
        fan2.setIsHyped(0);
        Fan fan3 = new Fan();
        fan3.setIsHyped(0);
        fan3.setFanId(3L);

        List<Fan> fansForFanClub1 = new ArrayList<>();
        fansForFanClub1.add(fan1);
        fansForFanClub1.add(fan2);
        List<Fan> fansForFanClub2 = new ArrayList<>();
        fansForFanClub2.add(fan3);
        fanClub1.setFan(fansForFanClub1);
        fanClub2.setFan(fansForFanClub2);
        merchandise.setPret(100);
        merchandise.setMerchandiseId(1L);
        merchandise.setTrupa(trupa);
        merchandise.discount(10);
        Assertions.assertEquals(fan1.isHyped() , 1);
        Assertions.assertEquals(fan2.isHyped() , 1);
        Assertions.assertEquals(fan3.isHyped() , 1);



    }
}
