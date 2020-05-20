package sample.Pattern.Command;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Classi.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Receiver
public class Receiver
{
    public void setAction_annulla(Button btn_elimina, String link, String email)
    {
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
}
