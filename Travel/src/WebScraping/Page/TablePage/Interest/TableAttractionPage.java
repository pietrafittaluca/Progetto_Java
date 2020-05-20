package WebScraping.Page.TablePage.Interest;
import WebScraping.Page.TablePage.Review.Bridge.GiornataDiRelax;
import WebScraping.Page.TablePage.Review.TableReviewAttractionPage;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;

import java.util.List;

public class TableAttractionPage extends TableInterestPage{

    public TableAttractionPage(String new_url, int page_num) {
        super(new_url, page_num);
    }

    public TableAttractionPage(String new_url, TableRestaurantPage new_prev_page, int new_page_num ){
        super(new_url,new_prev_page,new_page_num);
    }

    @Override
    public List<HtmlAnchor> getElement_list() {
        List<HtmlAnchor> element_list = (List<HtmlAnchor>) (Object) this.getPage().getByXPath("//a[@class='attractions-attraction-overview-pois-PoiInfo__name--SJ0a4']");
        return element_list;
    }

    @Override
    public TableReviewAttractionPage factoryMethod(String url){
        System.out.println("Sono nel factory method1");
        TableReviewAttractionPage tableReviewAttractionPage = new TableReviewAttractionPage(url, new GiornataDiRelax(), this.getPage_number());
        System.out.println("2-Sono nel factory method1");
        return tableReviewAttractionPage;
    }

    @Override
    public TableInterestPage getNextInterestPage() {
        return null;
    }
}
