package sample.Pattern.Factory;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Classi.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contenuto_utente extends Contenuto
{
    Button btn_elimina;

    public Contenuto_utente(String nome_offerta, String citta, String tipo, String link, String email)
    {
        this.col_nome_offerta = nome_offerta;
        this.col_citta = citta;
        this.col_tipo = tipo;

        this.btn_elimina = new Button("Elimina");

        btn_elimina.setOnAction(event -> {
            Database prova = Database.getInstance();
            Connection con = prova.getConnection();

            try
            {
                String query = "DELETE IGNORE FROM ha WHERE EMAIL=" + "'" + email + "' AND LINK=" + "'" + link + "'";

                con.setAutoCommit(false);
                PreparedStatement pstmt = con.prepareStatement(query);

                pstmt.executeUpdate();
                con.commit();
                con.setAutoCommit(true);
            }
            catch (SQLException ex)
            {
                try
                {
                    con.rollback();
                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

            Stage stageX = (Stage) btn_elimina.getScene().getWindow();
            stageX.close();
        });
    }

    public Button getBtn_elimina() {
        return btn_elimina;
    }

    public void setBtn_elimina(Button btn_elimina) {
        this.btn_elimina = btn_elimina;
    }
}
