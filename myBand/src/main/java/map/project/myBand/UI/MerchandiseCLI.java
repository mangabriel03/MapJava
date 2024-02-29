package map.project.myBand.UI;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Merchandise;
import map.project.myBand.Model.Trupa;
import map.project.myBand.Service.MerchandiseService;
import map.project.myBand.Service.TrupaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MerchandiseCLI {
    @Autowired
    private MerchandiseService merchandiseService;

    @Autowired
    private TrupaService trupaService;
    @ShellMethod(key = "find merch")
    public String findAllMerch(){
        return this.merchandiseService.findAllMerch().toString();
    }

    @ShellMethod(key = "add merch")
    public String addMerch(@ShellOption(value = {"nume"})String nume,
                           @ShellOption(value = {"stoc"}) int stoc,
                           @ShellOption(value = {"pret"}) int pret,
                           @ShellOption(value = {"trupa id"}) Long trupaId){
        try{
            Trupa trupa = this.trupaService.findTrupaById(trupaId);
            Merchandise merchandise = new Merchandise();
            merchandise.setTrupa(trupa);
            merchandise.setPret(pret);
            merchandise.setStoc(stoc);
            merchandise.setNumeProdus(nume);
            this.merchandiseService.addMerch(merchandise);
            return merchandise.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
    @ShellMethod(key = "delete merch")
    public String deleteMerch(@ShellOption(value = {"merch id"}) Long merchId){
        try{
            Merchandise merchandise = this.merchandiseService.deleteMerch(merchId);
            return merchandise.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    /**
     * call for observer
     * @param merchId
     * @param discount
     * @return
     */
    @ShellMethod(key = "discount")
    public String discount(@ShellOption(value = {"merch id"}) Long merchId,
                           @ShellOption(value = {"discount"}) int discount){
        try{
            Merchandise merchandise = this.merchandiseService.makeDiscountById(merchId , discount);
            return merchandise.toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
