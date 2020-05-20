package WebScraping;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.io.PrintStream;

///Singleton
public class WSInformation {

    private static WSInformation istance;
    private WebClient Connection = new WebClient(BrowserVersion.CHROME);
    private String basic_url = "https://www.tripadvisor.co.uk";
    private HtmlPage basic_page;
    private String city_name = "Achnaseen";

    private WSInformation(){}

    public static WSInformation getInstance(){
        if(istance == null) {
            istance = new WSInformation();
            try {
                System.setErr(new PrintStream("/dev/null"));
                istance.basic_page = istance.Connection.getPage(istance.basic_url);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return istance;
    }

    public String getBasic_url(){return istance.basic_url;}

    public HtmlPage getBasic_page(){return istance.basic_page;}

    public void setCity(String new_city_name){city_name =new_city_name;}

    public String getCity(){return city_name;}
}
