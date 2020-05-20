package WebScraping.Page.TablePage.Interest;
import WebScraping.Page.TablePage.Review.Bridge.Soggiorno;
import WebScraping.Page.TablePage.Review.TableReviewHotelPage;
import WebScraping.Page.TablePage.Review.TableReviewInterestPage;
import WebScraping.WSInformation;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;

import java.util.List;

public class TableHotelPage extends TableInterestPage {

    public TableHotelPage(String new_url, int page_num) {
        super(new_url, page_num);
    }

    public TableHotelPage(String new_url, TableHotelPage prev_page, int page_num) {
        super(new_url, prev_page, page_num);
    }

    @Override
    public List<HtmlAnchor> getElement_list() {
        List<HtmlAnchor> element_list = (List<HtmlAnchor>) (Object) this.getPage().getByXPath("//a[@class='property_title prominent ']");
        System.out.println("size: " +element_list.size());
        return element_list;
    }

    @Override
    public TableReviewInterestPage factoryMethod(String url) {
        System.out.println("Sono nel factory method2");
        return new TableReviewHotelPage(url, new Soggiorno(), this.getPage_number());
    }

    @Override
    public TableInterestPage getNextInterestPage() {
        String string_page_number = String.valueOf(this.getPage_number()+1);
        String url;
        HtmlAnchor next_page_anchor = this.getPage().getFirstByXPath("//a[@class='pageNum last   cx_brand_refresh_phase2' and @data-page-number=" + string_page_number + "]");
        if (next_page_anchor != null) {
            url = WSInformation.getInstance().getBasic_url() + next_page_anchor.getHrefAttribute();
            return new TableHotelPage(url,this.getPage_number()+1);
        } else {
            return null;
        }
    }
}
