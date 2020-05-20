package WebScraping.WSTemplateMethod;
import WebScraping.Page.BasicPage.CityPage;
import WebScraping.Page.TablePage.Interest.TableAttractionPage;
import WebScraping.Page.TablePage.Interest.TableHotelPage;
import WebScraping.Page.TablePage.Interest.TableInterestPage;
import WebScraping.Page.TablePage.Interest.TableRestaurantPage;
import WebScraping.Page.TablePage.ListTablePage.ListTableInterestPage;
import WebScraping.Page.TablePage.ListTablePage.ListTableReviewInterestPage;
import WebScraping.Page.TablePage.Review.Review;
import WebScraping.Page.TablePage.Review.TableReviewInterestPage;

import java.util.ArrayList;
import java.util.List;

public class WebScrapingTripAdvisor extends WebScrapingTemplate{

    WSFacade facade;
    CityPage cityPage;
    //List<ListTableInterestPage> listTableInterestPage;


    public WebScrapingTripAdvisor(String basic_url, String url){
        super(basic_url);
        this.cityPage = new CityPage(url);
        this.facade = new WSFacade();
        ///listTableInterestPage = new ArrayList<>();
    }

    public CityPage getCityPage(){
        return this.cityPage;
    }


    public void SetData() {
        if (this.getDownloadAttractionEnable()) {
            this.facade.setAttraction(this.cityPage);
        }
        if (this.getDownloadHotelEnable()){
           this.facade.setHotel(this.cityPage);
        }
        if(this.getDownloadRestaurantEnable()){
            this.facade.setRestaurant(this.cityPage);
            }
        }

        public void WebScrapingAlgorithm(){
            this.facade.downloadData();
        }
    }
