package WebScraping.Page.TablePage;
import WebScraping.Page.BasicPage.Page;
public abstract class TablePage extends Page{

        public TablePage(String url_page){
                super(url_page);
                System.out.println("Sono nel costruttore");
        }
        public TablePage(String url_page, TablePage new_prev_page, int new_page_num){
                super(url_page);
        }

        public abstract int OpenTable();

        public abstract TablePage getNextInterestPage();

}
