package sample.Classi;

public class Model_contenuto_utente
{
    String col_nome_offerta, col_citta, col_tipo;

    public Model_contenuto_utente(String col_nome_offerta, String col_citta, String col_tipo) {
        this.col_nome_offerta = col_nome_offerta;
        this.col_citta = col_citta;
        this.col_tipo = col_tipo;
    }

    public String getCol_nome_offerta() {
        return col_nome_offerta;
    }

    public void setCol_nome_offerta(String col_nome_offerta) {
        this.col_nome_offerta = col_nome_offerta;
    }

    public String getCol_citta() {
        return col_citta;
    }

    public void setCol_citta(String col_citta) {
        this.col_citta = col_citta;
    }

    public String getCol_tipo() {
        return col_tipo;
    }

    public void setCol_tipo(String col_tipo) {
        this.col_tipo = col_tipo;
    }
}
