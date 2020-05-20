package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Classi.Database;

import java.sql.SQLException;

public class Controller_pagina_login
{
    @FXML
    private TextField field_username;
    @FXML
    private PasswordField field_login_password;
    @FXML
    private Label label_status;

    private static String username_inserito;
    private static Controller_pagina_login controller; // Static reference to itself

    public Controller_pagina_login()
    {
        /* private constructor*/
    }

    public static Controller_pagina_login getInstance()
    {
        if (controller == null)
            controller = new Controller_pagina_login();

        return controller;
    }

    ///////////////////////////////////////////////////////////////////////////////////

    public String getUsername_inserito(){
        return username_inserito;
    }

    public void btn_login_Action(ActionEvent actionEvent) throws SQLException
    {
        Database prova = Database.getInstance();
        prova.getConnection();

        String password_inserita = field_login_password.getText();
        username_inserito = field_username.getText().toLowerCase();

        if(prova.checkUser(username_inserito, password_inserita) == 1)
        {
            label_status.setText("LogIn Status: UTENTE TROVATO!");
            label_status.setTextFill(Color.GREEN);
            System.out.println("Utente trovato\n");

            // APRO LA PAGINA BACHECA_PRINCIPALE
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pagina_bacheca_principale.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Bacheca Principale");
                stage.setScene(new Scene(root1));
                stage.show();
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(prova.getInfo("utente", "EMAIL", username_inserito).isEmpty())
        {
            label_status.setText("LogIn Status: UTENTE NON TROVATO!");
            label_status.setTextFill(Color.RED);
        }
        else
        {
            label_status.setText("LogIn Status: ERROR!");
            label_status.setTextFill(Color.RED);
        }
    }

    public void btn_login_registrati_Action(ActionEvent actionEvent)
    {
        // APRO LA PAGINA DI REGISTRAZIONE
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pagina_registrazione.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registrazione");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
