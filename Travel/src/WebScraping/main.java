package WebScraping;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WebScraping.Page.BasicPage.CityPage;
import WebScraping.Page.TablePage.Interest.TableAttractionPage;
import WebScraping.Page.TablePage.Interest.TableHotelPage;
import WebScraping.Page.TablePage.Interest.TableInterestPage;
import WebScraping.Page.TablePage.ListTablePage.ListTableInterestPage;
import WebScraping.Page.TablePage.ListTablePage.ListTableReviewInterestPage;
import WebScraping.Page.TablePage.Review.*;
import WebScraping.Page.TablePage.Review.Bridge.GiornataDiRelax;
import WebScraping.Page.TablePage.Review.Bridge.Soggiorno;
import WebScraping.WSTemplateMethod.WebScrapingTripAdvisor;

public class main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        System.setErr(new PrintStream("/dev/null"));
        WebScrapingTripAdvisor pr = new WebScrapingTripAdvisor("https://www.tripadvisor.co.uk", "https://www.tripadvisor.co.uk/Tourism-g551704-Abbotsbury_Weymouth_Dorset_England-Vacations.html");
        pr.EnableDownloadAttraction();
        pr.EnableDownloadHotel();
        pr.EnableDownloadRestaurant();
        pr.SetData();
        pr.WebScrapingAlgorithm();

    }
}