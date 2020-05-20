package WebScraping.Page.TablePage.Review.Bridge;
import WebScraping.Page.TablePage.Review.TableReviewInterestPage;
import WebScraping.WSInformation;
import sample.Classi.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class GiornataDiRelax extends BridgeInsertDatabase{

    public GiornataDiRelax(){}

    @Override
    public void insertTravelDatabase(String offer_name, String url_page) throws SQLException {
        Database db = Database.getInstance();
        Connection con = db.getConnection();
        System.out.println("Sto inserendo sul db");
        System.out.println("oFFERNAME" + offer_name);
        System.out.println("page_url" + url_page);
        System.out.println("get_city" + WSInformation.getInstance().getCity());
        db.insertViaggio(offer_name, url_page, WSInformation.getInstance().getCity(), "Giornata di relax");
        System.out.println("Ho inserito sul db");
    }
}
