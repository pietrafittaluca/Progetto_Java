package sample.Classi;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_table_utente
{
    String col_nome_offerta, col_citta, col_tipo;
    Button btn_elimina;

    public Model_table_utente(String nome_offerta, String citta, String tipo, String link, String email)
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

            /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("/sample.pagina_bacheca_utente.fxml"));
            Parent root1 = null;
            try
            {
                root1 = fxmlLoader.load();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            stageX = new Stage();
            stageX.initModality(Modality.APPLICATION_MODAL);
            stageX.setTitle("Bacheca Utente");
            stageX.setScene(new Scene(root1));
            stageX.show();*/

            /*try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.pagina_bacheca_utente.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Bacheca Utente");
                stage.setScene(new Scene(root1));
                stage.show();
                // ((Node) (event.getSource())).getScene().getWindow().hide();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }*/
        });
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

    public Button getBtn_elimina() {
        return btn_elimina;
    }

    public void setBtn_elimina(Button btn_elimina) {
        this.btn_elimina = btn_elimina;
    }
}
