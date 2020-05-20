package WebScraping.WSTemplateMethod;

///Si è optato per l'utilizzo del pattern Template Method
///per consentire la possibilità futura di nuovi sviluppi
///mediante l'estensione del WebScraping ad altri siti
///che potrebbero avere una gestione delle pagine totalmente differente
///da quella dell'unico sito trattato in questo progetto ossia TripAdvisor
public abstract class WebScrapingTemplate {
    ///DownloadAttractionEnabled specifica se si vuole scaricare o meno le attrazioni
    boolean DownloadAttractionEnabled = false;
    ///DownloadAttractionEnabled specifica se si vuole scaricare o meno gli alberghi
    boolean DownloadHotelEnabled = false;
    ///DownloadAttractionEnabled specifica se si vuole scaricare o meno i ristoranti
    boolean DownloadRestaurantEnabled = false;

    String basic_url;

    public WebScrapingTemplate(String new_basic_url){
        basic_url = new_basic_url;
    }

    ///Il seguente metodo è astratto in quanto l'algoritmo di WebScraping
    ///varia in base al sito a partire dal quale si vuole eseguire
    public abstract void WebScrapingAlgorithm();

    ///Il seguente metodo restituisce l'url della home page del sito da cui si vuole fare Web Scraping
    public String getBasic_url(){return this.basic_url;}

    //Il seguente metodo consente di attivare il download delle attrazioni
    public void EnableDownloadAttraction(){this.DownloadAttractionEnabled = true;}

    //Il seguente metodo consente di attivare il download degli alberghi
    public void EnableDownloadHotel(){this.DownloadHotelEnabled = true;}

    //Il seguente metodo consente di attivare il download dei ristoranti
    public void EnableDownloadRestaurant(){this.DownloadRestaurantEnabled = true;}

    //Il seguente metodo consente di disattivare il download delle attrazioni
    public void DisableDownloadAttraction(){this.DownloadAttractionEnabled = false;}

    //Il seguente metodo consente di disattivare il download degli alberghi
    public void DisableDownloadHotel(){this.DownloadHotelEnabled = false;}

    //Il seguente metodo consente di disattivare il download dei ristoranti
    public void DisableDownloadRestaurant(){this.DownloadRestaurantEnabled = false;}

    public boolean getDownloadAttractionEnable(){return this.DownloadAttractionEnabled;}

    public boolean getDownloadHotelEnable(){return this.DownloadHotelEnabled;}

    public boolean getDownloadRestaurantEnable(){return this.DownloadRestaurantEnabled;}
}
