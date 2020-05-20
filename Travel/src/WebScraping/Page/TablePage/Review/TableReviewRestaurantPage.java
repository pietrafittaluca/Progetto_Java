package WebScraping.Page.TablePage.Review;
import WebScraping.Page.TablePage.Review.Bridge.BridgeInsertDatabase;
import WebScraping.Page.TablePage.Review.Bridge.GiornataDiRelax;
import WebScraping.WSInformation;
import com.gargoylesoftware.htmlunit.html.Html;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import java.util.List;


public class TableReviewRestaurantPage extends TableReviewInterestPage{

    public TableReviewRestaurantPage(String url, BridgeInsertDatabase newPolicyDatabase, int page_number) {
        super(url, newPolicyDatabase, page_number);
        HtmlElement title = this.getPage().getFirstByXPath("//h1[@class='restaurants-detail-top-info-TopInfo__restaurantName--1IKBe ui-header h1']");
        System.out.println("Trovato?");
        this.setOffer_name(title.getTextContent());
    }
    public TableReviewRestaurantPage(String url, BridgeInsertDatabase newPolicyDatabase, String offer_name, int page_number) {
        super(url, newPolicyDatabase, offer_name, page_number);
    }

    @Override
    public List<HtmlElement> getHtmlElementList() {
        List<HtmlElement> ReviewList = (List<HtmlElement>)(Object)this.getPage().getByXPath("//p[@class='partial_entry']");
        return ReviewList;
    }

    @Override
    public String getTextHtmlElement(HtmlElement reviewElement)
    {
        return reviewElement.getTextContent();
    }

    @Override
    public TableReviewInterestPage getNextInterestPage(){
        String string_page_number = String.valueOf(this.getPage_number()+1);
        String url;
        HtmlAnchor next_el = null;
        System.out.println("Sono qui, pre bug");
        System.out.println("Sto cercando: " + string_page_number + "su: "+this.getPage_url());
        next_el = (HtmlAnchor) this.getPage().getFirstByXPath("//a[@class='nav next ui_button primary  cx_brand_refresh_phase2']");
        if (next_el != null) {
            url = WSInformation.getInstance().getBasic_url() + next_el.getHrefAttribute();
            System.out.println(url);
            return new TableReviewRestaurantPage(url, new GiornataDiRelax(), this.getOffer_name(), this.getPage_number()+1);
        }
        else {
            return null;
        }
    }

}
