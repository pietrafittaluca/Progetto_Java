package WebScraping.Page.TablePage.Review.Bridge;
import WebScraping.Page.TablePage.Review.TableReviewInterestPage;


import java.sql.SQLException;

public abstract class BridgeInsertDatabase {

    ///private String page_url;

    public BridgeInsertDatabase(){};

    public abstract void insertTravelDatabase(String offer_name, String url_page) throws SQLException;

    ///public TableReviewInterestPage getTableReviewInterestPage(){return this.tableReviewInterestPage;}

    ///public String getPage_url(){return this.page_url;}
}
