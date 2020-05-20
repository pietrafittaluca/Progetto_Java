package WebScraping.WSTemplateMethod;


import WebScraping.Page.BasicPage.CityPage;
import WebScraping.Page.TablePage.Interest.TableAttractionPage;
import WebScraping.Page.TablePage.Interest.TableHotelPage;
import WebScraping.Page.TablePage.Interest.TableInterestPage;
import WebScraping.Page.TablePage.Interest.TableRestaurantPage;
import WebScraping.Page.TablePage.ListTablePage.ListTableInterestPage;
import WebScraping.Page.TablePage.ListTablePage.ListTableReviewInterestPage;

import java.util.ArrayList;
import java.util.List;

public class WSFacade {
    private List<ListTableInterestPage> listTableInterestPage;


    WSFacade(){
        listTableInterestPage = new ArrayList<>();
    }

    public void addListTableInterestPage(ListTableInterestPage listTableInterestPage){
        this.listTableInterestPage.add(listTableInterestPage);
    }

    public void setAttraction(CityPage cityPage){
        String AttractionPageUrl = cityPage.findAttractionPageUrl();
        if(AttractionPageUrl != null) {
            System.out.println("Sono in attraction");
            TableAttractionPage tmpTableAttractionPage = new TableAttractionPage(AttractionPageUrl,1);
            ListTableInterestPage tmpListTableInterestPage= new ListTableInterestPage(tmpTableAttractionPage);
            this.addListTableInterestPage(tmpListTableInterestPage);
        }
    }

    public void setHotel(CityPage cityPage){
        String HotelPageUrl = cityPage.findHotelPageUrl();
        if(HotelPageUrl != null) {
            System.out.println("Sono in hotel");
            TableHotelPage tmpTableHotelPage = new TableHotelPage(HotelPageUrl,1);
            ListTableInterestPage tmpListTableInterestPage = new ListTableInterestPage(tmpTableHotelPage);
            this.addListTableInterestPage(tmpListTableInterestPage);
        }
    }

    public void setRestaurant(CityPage cityPage){
        String RestaurantPageUrl = cityPage.findRestaurantPageUrl();
        if(RestaurantPageUrl != null) {
            System.out.println("Sono in restaurant");
            TableRestaurantPage tmpTableRestaurantPage = new TableRestaurantPage(RestaurantPageUrl,1);
            ListTableInterestPage tmpListTableInterestPage = new ListTableInterestPage(tmpTableRestaurantPage);
            this.addListTableInterestPage(tmpListTableInterestPage);
        }
    }

    public void downloadData(){
        System.out.println("downlaod data");
        for (ListTableInterestPage it_listTableInterestPage: listTableInterestPage){
            it_listTableInterestPage.addAllPages();
            List <TableInterestPage> tmpListTableInterestPage = it_listTableInterestPage.getListTableInterestPage();
            for (TableInterestPage it_tableInterestPage: tmpListTableInterestPage){
                it_tableInterestPage.OpenTable();
                List <ListTableReviewInterestPage> tmpListListTableReviewInterestPage = it_tableInterestPage.getListReviewPage();
                for (ListTableReviewInterestPage it_listTableReviewInterestPage: tmpListListTableReviewInterestPage){
                    it_listTableReviewInterestPage.addAllPages();
                    it_listTableInterestPage.addAllPages();
                    //List <TableReviewInterestPage> tmpListTableReviewInterestPage = it_listTableReviewInterestPage.getListTableReviewInterestPage();
                    //for (TableReviewInterestPage it_tableReviewInterestPage :tmpListTableReviewInterestPage){
                    //it_tableReviewInterestPage.OpenTable();
                    //List <Review> reviewList = it_tableReviewInterestPage.getList_reviews();
                    //for (Review it_review : reviewList){
                    //  it_review.analyzeText_content();
                    //}
                }
            }
        }
    }
}
