package WebScraping.Page.BasicPage;
import WebScraping.WSInformation;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import java.util.List;

public class CityPage extends Page{

    private String city_name;

    public CityPage(String url_page){super(url_page); setCity_name();}

    public CityPage(String url_page, String newCity_name){super(url_page); city_name = newCity_name;}

    public String getCity_name(){return this.city_name;}

    public void setCity_name(String newCity_name){this.city_name = newCity_name; WSInformation a = WSInformation.getInstance(); a.setCity(newCity_name);}

    public void setCity_name(){
        HtmlSpan tmp_city_name=  this.getPage().getFirstByXPath("//span[@class='{geoClass}']");
        this.city_name = tmp_city_name.getTextContent();
    }


    public String findAttractionPageUrl(){
        String Complete_URL;
        System.out.println(this.page_url);
        HtmlAnchor page_Anchor = null;
        page_Anchor = (HtmlAnchor) this.getPage().getFirstByXPath("//a[@title='Things to Do']");
        System.out.println("Post anchor");
        if(page_Anchor!=null){
                Complete_URL = WSInformation.getInstance().getBasic_url() + page_Anchor.getHrefAttribute();
                return Complete_URL;
        }
        return null;
    }

    public String findHotelPageUrl() {
        String Complete_URL;
        HtmlAnchor page_Anchor = (HtmlAnchor) this.getPage().getFirstByXPath("//a[@title='Hotels']");
        if(page_Anchor!=null){
                Complete_URL = WSInformation.getInstance().getBasic_url() + page_Anchor.getHrefAttribute();
                return Complete_URL;
        }
        return null;
    }

    public String findRestaurantPageUrl() {
        String Complete_URL;
        HtmlAnchor page_Anchor = (HtmlAnchor) this.getPage().getFirstByXPath("//a[@title='Restaurants']");
        if(page_Anchor!=null){
                Complete_URL = WSInformation.getInstance().getBasic_url() + page_Anchor.getHrefAttribute();
                return Complete_URL;
        }
        return null;
    }

}
