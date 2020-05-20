package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Classi.Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Controller_pagina_registrazione
{
    @FXML
    private TextField field_nome;
    @FXML
    private TextField field_cognome;
    @FXML
    private TextField field_citta;
    @FXML
    private TextField field_email;
    @FXML
    private PasswordField field_password;
    @FXML
    private Label label_status;
    @FXML
    private Button btn_registrati;

    private static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public void btn_registrati_Action(ActionEvent actionEvent) throws SQLException, InterruptedException
    {
        Database prova = Database.getInstance();
        prova.getConnection();

        String nome_inserito = field_nome.getText().toLowerCase();
        String cognome_inserito = field_cognome.getText().toLowerCase();
        String citta_inserita = field_citta.getText().toLowerCase();
        String username_inserito = field_email.getText().toLowerCase();
        String password_inserita = field_password.getText();

        if(nome_inserito.isEmpty() || cognome_inserito.isEmpty() || citta_inserita.isEmpty() || username_inserito.isEmpty() || password_inserita.isEmpty())
        {
            label_status.setText("SigIn Status: Tutti i campi sono obbligatori");
            label_status.setTextFill(Color.RED);
        }
        else if(!prova.getInfo("utente", "EMAIL", username_inserito).isEmpty())
        {
            label_status.setText("SigIn Status: UTENTE GIÀ PRESENTE!");
            label_status.setTextFill(Color.RED);
        }
        else if (!isValid(username_inserito))
        {
            label_status.setText("SigIn Status: EMAIL NON VALIDA");
            label_status.setTextFill(Color.RED);
        }
        else
        {
            ArrayList<String> tuple = new ArrayList<String>();
            tuple.add(nome_inserito);
            tuple.add(cognome_inserito);
            tuple.add(citta_inserita);
            tuple.add(username_inserito);
            tuple.add(password_inserita);
            prova.insertRow("UTENTE", tuple);

            Stage stage2 = (Stage) btn_registrati.getScene().getWindow();
            stage2.close();

            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pagina_ok_registrazione.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Registrazione Completata");
                stage.setScene(new Scene(root1));
                stage.show();
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
