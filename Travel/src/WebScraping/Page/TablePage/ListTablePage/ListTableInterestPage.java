package WebScraping.Page.TablePage.ListTablePage;
import WebScraping.Page.TablePage.Interest.TableInterestPage;
import WebScraping.Page.TablePage.TablePage;

import java.util.ArrayList;
import java.util.List;

public class ListTableInterestPage <E extends TableInterestPage> implements ListTablePage{

    private List<E> listTableInterestPage;

    public ListTableInterestPage(E newTableInterestPage){
        listTableInterestPage = new ArrayList<>();
        newTableInterestPage.OpenTable();
        listTableInterestPage.add(newTableInterestPage);
    }

    public void addAllPages(){
        System.out.println("ListTableInterestPage - addAllPage");
        boolean OtherPage = addNextPage();
        while (OtherPage == true) {
            OtherPage = addNextPage();
        }
    }

    public boolean addNextPage(TablePage lastElementTableReviewInterestPage) {
        return false;
    }

    public boolean addNextPage() {
        E lastElementTableInterestPage = listTableInterestPage.get(listTableInterestPage.size()-1);
        System.out.println("ListTableInterestPage - addNextPage");
        TableInterestPage nextTableInterestPage = lastElementTableInterestPage.getNextInterestPage();
        if (nextTableInterestPage != null) {
            nextTableInterestPage.OpenTable();
            listTableInterestPage.add((E) nextTableInterestPage);
            return true;
        } else
            return false;
    }

    public List<E> getListTableInterestPage(){return this.listTableInterestPage;}

}
