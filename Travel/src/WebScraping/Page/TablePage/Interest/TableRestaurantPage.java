package WebScraping.Page.TablePage.Interest;
import WebScraping.Page.TablePage.Review.Bridge.GiornataDiRelax;
import WebScraping.Page.TablePage.Review.TableReviewRestaurantPage;
import WebScraping.Page.TablePage.TablePage;
import WebScraping.WSInformation;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;

import java.util.List;

public class TableRestaurantPage extends TableInterestPage {

    public TableRestaurantPage(String new_url, int page_number) {
        super(new_url, page_number);
    }

    public TableRestaurantPage(String new_url, TableRestaurantPage new_prev_page, int new_page_num ){
        super(new_url,new_prev_page,new_page_num);
    }

    @Override
    public List<HtmlAnchor> getElement_list() {
        List<HtmlAnchor> element_list = (List<HtmlAnchor>) (Object) this.getPage().getByXPath("//a[@class='_15_ydu6b']");
        return element_list;
    }

    @Override
    public TableReviewRestaurantPage factoryMethod(String url){
        System.out.println("Sono nel factory method3");
        return new TableReviewRestaurantPage(url, new GiornataDiRelax(), this.getPage_number());
    }

    @Override
    public TableInterestPage getNextInterestPage() {
        String string_page_number = String.valueOf(this.getPage_number()+1);
        HtmlAnchor next_page_anchor = this.getPage().getFirstByXPath("//a[@data-page-number=" + string_page_number + "]");
        String url;
        if(next_page_anchor != null){
            url = WSInformation.getInstance().getBasic_url() + next_page_anchor.getTextContent();
            return new TableRestaurantPage(url, this.getPage_number()+1);
        }
        return null;
        }

}
