package WebScraping.Page.TablePage.ListTablePage;

import WebScraping.Page.TablePage.Interest.TableInterestPage;
import WebScraping.Page.TablePage.Review.Review;
import WebScraping.Page.TablePage.TablePage;
import WebScraping.Page.TablePage.Review.TableReviewInterestPage;
import sample.Classi.Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListTableReviewInterestPage implements ListTablePage{

    private List<TableReviewInterestPage> listTableReviewInterestPage;

    public ListTableReviewInterestPage(TableReviewInterestPage newTableInterestPage){
        this.listTableReviewInterestPage = new ArrayList<>();
        newTableInterestPage.OpenTable();
        this.listTableReviewInterestPage.add(newTableInterestPage);
    }

    public void addAllPages(){
        boolean OtherPage = addNextPage();
        while (OtherPage == true) {
            System.out.println("Numero pagine recensioni corrente:" + this.listTableReviewInterestPage.size());
            OtherPage = addNextPage();
        }

        System.out.println("Pre insert db");
        this.insertTravelDatabase();
        System.out.println("Pre insert Reviews");
        try {
            this.insertReviewsDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean addNextPage(){
        System.out.println("Inizio add");
        System.out.println(listTableReviewInterestPage.size()-1);
        TableReviewInterestPage lastElementTableReviewInterestPage = listTableReviewInterestPage.get(listTableReviewInterestPage.size()-1);
        TableReviewInterestPage nextTableReviewInterestPage = lastElementTableReviewInterestPage.getNextInterestPage();
        System.out.println("Sono in add nextpage");
        if (nextTableReviewInterestPage != null) {
            System.out.println("Prova");
            nextTableReviewInterestPage.OpenTable();
            System.out.println("Prova2");
            listTableReviewInterestPage.add(nextTableReviewInterestPage);
            return true;
        }
        else {
            return false;
        }
    }

    public List<TableReviewInterestPage> getListTableReviewInterestPage(){return this.listTableReviewInterestPage;}

    public void insertTravelDatabase() {
        TableReviewInterestPage iterator = this.listTableReviewInterestPage.get(0);
            try {
                System.out.println("Offer_name" + iterator.getOffer_name());
                System.out.println("GetPageurl" + iterator.getPage_url());
               iterator.getPolicyInsert().insertTravelDatabase(iterator.getOffer_name(), iterator.getPage_url());
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void insertReviewsDatabase() throws SQLException {
        Database db = Database.getInstance();
        db.getConnection();
        List<Review> listTableRev;
        int id;
        TableReviewInterestPage trip = this.listTableReviewInterestPage.get(0);
        String url_pag = trip.getPage_url();
        float sum_vp = 0.0f, sum_p= 0.0f, sum_neu= 0.0f, sum_neg=0.0f, sum_vn=0.0f;
        float vp=0.0f, p=0.0f, neu=0.0f, neg=0.0f, vn=0.0f;
        int count = 0;
        for (TableReviewInterestPage iterator: this.listTableReviewInterestPage){
            listTableRev = iterator.getList_reviews();
            for (Review it: listTableRev){
                count++;
                System.out.println(count);
                id = db.insertRecensione(it.getText_content(),url_pag);
                //it.analyzeText_content();
                sum_vp+=it.getSentimentClassification().getVeryPositive();
                System.out.println(sum_vp);
                sum_p+=it.getSentimentClassification().getPositive();
                System.out.println(sum_p);
                sum_neu+=it.getSentimentClassification().getNeutral();
                System.out.println(sum_neu);
                sum_neg+=it.getSentimentClassification().getNegative();
                System.out.println(sum_neg);
                sum_vn+=it.getSentimentClassification().getVeryNegative();
                System.out.println(sum_vn);
                db.insertRecensione_SentimentScore(id,it.getSentimentClassification().getVeryPositive(),it.getSentimentClassification().getPositive(),it.getSentimentClassification().getNeutral(),it.getSentimentClassification().getNegative(),it.getSentimentClassification().getVeryNegative());
            }
            if(count!=0) {
                vp = sum_vp / count;
                p = sum_p / count;
                neu = sum_neu / count;
                neg = sum_neg / count;
                vn = sum_vn / count;
            }
            System.out.println("PRE-INSERIMENTO: " + vp);
            System.out.println(p);
            System.out.println(neu);
            System.out.println(neg);
            System.out.println(vn);
            db.insertViaggio_SentimentScore(url_pag, vp, p, neu, neg, vn);
        }
    }
}
