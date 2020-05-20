package WebScraping.Page.TablePage.Review.Bridge;
import WebScraping.WSInformation;
import sample.Classi.Database;
import java.sql.SQLException;

public class Soggiorno extends BridgeInsertDatabase{


    public Soggiorno(){}

    @Override
    public void insertTravelDatabase(String offer_name, String url_page) throws SQLException {
        Database db;
        db = Database.getInstance();
        db.getConnection();
        System.out.println("Sto inserendo sul db");
        db.insertViaggio(offer_name, url_page, WSInformation.getInstance().getCity(), "Soggiorno");
        System.out.println("Ho inserito su db");
    }
}
