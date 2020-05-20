package sample.Pattern.Command;

import javafx.scene.control.Button;

// Concrete Command
public class Btn_annulla implements Command
{
    String col_nome_offerta, col_citta, col_tipo, link, email;
    Button btn_elimina;
    Receiver obj;

    public Btn_annulla(String nome_offerta, String citta, String tipo, String link, String email)
    {
        this.col_nome_offerta = nome_offerta;
        this.col_citta = citta;
        this.col_tipo = tipo;
        this.link = link;
        this.email = email;

        this.btn_elimina = new Button("Elimina");
    }

    @Override
    public void execute()
    {
        obj.setAction_annulla(btn_elimina, link, email);
    }
}