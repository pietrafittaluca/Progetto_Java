package WebScraping.Page.TablePage.Interest;
import WebScraping.Page.TablePage.ListTablePage.ListTableReviewInterestPage;
import WebScraping.Page.TablePage.Review.TableReviewInterestPage;
import WebScraping.Page.TablePage.TablePage;
import WebScraping.WSInformation;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;

import java.util.ArrayList;
import java.util.List;

public abstract class TableInterestPage extends TablePage {

    private List<ListTableReviewInterestPage> listReviewPage;
    private int page_number;

    TableInterestPage(String new_url, int page_number) {
        super(new_url);
        listReviewPage = new ArrayList<>();
        this.page_number = page_number;
        //this.OpenTable();
    }

    TableInterestPage(String new_url, TableInterestPage new_prev_page, int new_page_num ){
        super(new_url,new_prev_page,new_page_num);
    }

    public int OpenTable(){
        System.out.println("Sono qui");
        String new_url;
        int count_element = 0;
        List <HtmlAnchor> element_list = this.getElement_list();
        for (HtmlAnchor it_element: element_list) {
            count_element++;
            new_url = WSInformation.getInstance().getBasic_url() + it_element.getHrefAttribute();
            System.out.println("Url della pagina: " + new_url);
            this.listReviewPage.add(new ListTableReviewInterestPage(this.factoryMethod(new_url)));
        }
        return count_element;
    }

    public abstract TableInterestPage getNextInterestPage();

    public abstract List<HtmlAnchor> getElement_list();

    public abstract TableReviewInterestPage factoryMethod(String url);

    public  List<ListTableReviewInterestPage> getListReviewPage(){return this.listReviewPage;}

    public int getPage_number(){return this.page_number;}
}
