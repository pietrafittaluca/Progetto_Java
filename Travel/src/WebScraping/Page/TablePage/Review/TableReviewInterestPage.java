package WebScraping.Page.TablePage.Review;
import WebScraping.Page.TablePage.TablePage;
import WebScraping.Page.TablePage.Review.Bridge.BridgeInsertDatabase;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import sample.Classi.Database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class TableReviewInterestPage extends TablePage {

    private String offer_name;
    private List <Review> list_reviews;
    private BridgeInsertDatabase policyInsert;
    private int page_number;

    public TableReviewInterestPage(String url_page, BridgeInsertDatabase newPolicyInsert, int page_number) {
        super(url_page);
        System.out.println("L'url della tabella di recensioni è: " + url_page);
        this.list_reviews = new ArrayList<>();
        this.policyInsert = newPolicyInsert;
        this.page_number = page_number;
    }

    public TableReviewInterestPage(String url_page, BridgeInsertDatabase newPolicyInsert, String offer_name, int page_number) {
        super(url_page);
        System.out.println("L'url della tabella di recensioni è: " + url_page);
        this.list_reviews = new ArrayList<>();
        this.policyInsert = newPolicyInsert;
        this.offer_name = offer_name;
        this.page_number = page_number;
    }

    @Override
    public int OpenTable(){
        System.out.println("Sono in open table");
        String text_content;
        int count_reviews = 0;
        List <HtmlElement> HtmlElementReviewList = this.getHtmlElementList();
        for (HtmlElement it_Review : HtmlElementReviewList) {
            count_reviews++;
            text_content = this.getTextHtmlElement(it_Review);
            System.out.println("Numero recensione corrente" + count_reviews + "testo " +  text_content);
            this.list_reviews.add(new Review(text_content));
        }
        return count_reviews;
    }

    public abstract List<HtmlElement> getHtmlElementList();

    public abstract String getTextHtmlElement(HtmlElement reviewElement);

    public abstract TableReviewInterestPage getNextInterestPage();

    public List<Review> getList_reviews(){return this.list_reviews;}

    public BridgeInsertDatabase getPolicyInsert(){return this.policyInsert;}

    public int getPage_number(){return this.page_number; }

    public String getOffer_name(){return this.offer_name;}

    public void setOffer_name(String title){this.offer_name=title;}

};

