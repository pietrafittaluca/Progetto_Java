package WebScraping.Page.BasicPage;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public abstract class Page {

    WebClient connection = new WebClient(BrowserVersion.CHROME);
    String page_url;
    HtmlPage page;

    public Page(String newPage_url) {
        System.out.println("Sono in PAGE");
        page_url = newPage_url;
        System.out.println("Ho stabilito l'url");
        try {
            page = connection.getPage(newPage_url);
            System.out.println("Ho stabilito la connessione");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getPage_url() {
        return this.page_url;
    }

    public WebClient getConnection(){
        return this.connection;
    }

    public HtmlPage getPage(){
        return this.page;
    }
}
