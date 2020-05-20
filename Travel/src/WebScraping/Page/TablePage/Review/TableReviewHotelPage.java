package WebScraping.Page.TablePage.Review;
import WebScraping.Page.TablePage.Review.Bridge.BridgeInsertDatabase;
import WebScraping.Page.TablePage.Review.Bridge.Soggiorno;
import WebScraping.WSInformation;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

import java.sql.SQLException;
import java.util.List;

public class TableReviewHotelPage extends TableReviewInterestPage {

    public TableReviewHotelPage(String url , BridgeInsertDatabase newPolicyDatabase, int page_number){
        super(url, newPolicyDatabase, page_number);
        HtmlElement title = this.getPage().getFirstByXPath("//h1[@class='hotels-hotel-review-atf-info-parts-Heading__heading--2ZOcD']");
        System.out.println("Trovato?");
        this.setOffer_name(title.getTextContent());
    }

    public TableReviewHotelPage(String url , BridgeInsertDatabase newPolicyDatabase, String offer_name, int page_number){
        super(url, newPolicyDatabase, offer_name, page_number);
    }

    @Override
    public List<HtmlElement> getHtmlElementList() {
        List <HtmlElement> reviewList = this.getPage().getByXPath("//q[@class='location-review-review-list-parts-ExpandableReview__reviewText--gOmRC']");
        return reviewList;
    }

    @Override
    public String getTextHtmlElement(HtmlElement reviewElement) {
        HtmlSpan tmpRev = (HtmlSpan) reviewElement.getFirstChild();
        if (tmpRev != null)
            return tmpRev.getTextContent();
        else
            return null;
    }

    @Override
    public TableReviewInterestPage getNextInterestPage(){
        String string_page_number = String.valueOf(this.getPage_number()+1);
        String url;
        HtmlAnchor next_el = null;
        next_el = (HtmlAnchor) this.getPage().getFirstByXPath("//a[.=" + string_page_number + " and @class='pageNum cx_brand_refresh_phase2 ']");
        if (next_el != null) {
            url = WSInformation.getInstance().getBasic_url() + next_el.getHrefAttribute();
            return new TableReviewAttractionPage(url, new Soggiorno(), this.getOffer_name(), this.getPage_number()+1);
        }
        else {
            return null;
        }
    }

}
