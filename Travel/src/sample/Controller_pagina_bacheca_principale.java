package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Classi.Database;
import sample.Classi.Model_table_principale;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller_pagina_bacheca_principale implements Initializable
{
    @FXML private ChoiceBox<String> choice_btn_umore, choice_btn_citta, choice_btn_tipo, choice_btn_prezzo, choice_btn_npersone;
    @FXML private DatePicker datepicker_btn_datainizio, datepicker_btn_datafine;
    @FXML private Label id_label;
    @FXML private TableView<Model_table_principale> id_table;
    @FXML private TableColumn<Model_table_principale, String> col_nome_offerta, col_citta, col_tipo;
    @FXML private TableColumn<Model_table_principale, Float> col_molto_positivo, col_positivo, col_neutrale, col_negativo, col_molto_negativo;
    @FXML private TableColumn<Model_table_principale, Button> col_link, col_salva;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        // Umore
        choice_btn_umore.getItems().add("Triste");
        choice_btn_umore.getItems().add("Stanco");
        choice_btn_umore.getItems().add("Annoiato");
        choice_btn_umore.getItems().add("Felice");

        // Tipo
        choice_btn_tipo.getItems().add("Soggiorno");
        choice_btn_tipo.getItems().add("Giornata di Relax");

        // Città
        choice_btn_citta.getItems().add("lairg");
        choice_btn_citta.getItems().add("garve");
        choice_btn_citta.getItems().add("portmeirion");
        choice_btn_citta.getItems().add("achnaseen");

        // Prezzo
        choice_btn_prezzo.getItems().add("< 50");
        choice_btn_prezzo.getItems().add("< 100");
        choice_btn_prezzo.getItems().add("< 150");
        choice_btn_prezzo.getItems().add("> 150");

        // N. Persone
        choice_btn_npersone.getItems().add("1");
        choice_btn_npersone.getItems().add("2");
        choice_btn_npersone.getItems().add("3");
        choice_btn_npersone.getItems().add("4");
        choice_btn_npersone.getItems().add("5");
        choice_btn_npersone.getItems().add("6");
    }

    //////////////////////////////////////////////////////////////////////////////////////
    /////////////////// METODO PER IL POPOLAMENTO DELLA TABELLA
    //////////////////////////////////////////////////////////////////////////////////////
    public void btn_cerca_Action(ActionEvent actionEvent)
    {
        String umore = choice_btn_umore.getValue(); // Triste, Stanco, Annoiato, Felice
        String tipo = choice_btn_tipo.getValue(); // Viaggio o Relax
        String citta = choice_btn_citta.getValue();
        System.out.println("citta: " + citta);
        String prezzo = choice_btn_prezzo.getValue(); // < 50, < 100, < 150, > 150
        String n_persone = choice_btn_npersone.getValue(); // Da 1 a 6
        LocalDate data_inizio = datepicker_btn_datainizio.getValue();
        LocalDate data_fine = datepicker_btn_datafine.getValue();

        if(umore == null || tipo == null || citta == null || prezzo == null || n_persone == null || data_inizio == null || data_fine == null)
        {
            id_label.setTextFill(Color.RED);
            id_label.setText("ATTENZIONE: Inserisci tutti i dati.");
        }
        else if(data_inizio.isBefore(LocalDate.now()) || data_fine.isBefore(data_inizio))
        {
            id_label.setTextFill(Color.RED);
            id_label.setText("ATTENZIONE: Date inserite sbagliate.");
        }
        else
        {
            id_label.setText("Ricerca Effettuata.");
            id_label.setTextFill(Color.GREEN);

            //umore.equals(umore.toLowerCase());
            //citta.equals(citta.toLowerCase());

            //////////////////////////////////////////////////////////////////////////////////////
            // ESEMPIO DI INSERIMENTO RIGA
            Database prova = Database.getInstance();
            Connection con = prova.getConnection();
            ObservableList<Model_table_principale>list = FXCollections.observableArrayList();

            try
            {
                String f = "grave";
                System.out.println("citta: " + citta+ citta.length() + f.length());
                if(f instanceof String)
                    System.out.println("Ok");
                if(citta instanceof String)
                    System.out.println("Ok1");
                if(tipo instanceof String)
                System.out.println("Ok2");

                System.out.println("tipo: "+ tipo);
                Statement prov = con.createStatement();
                String proviamo = "SELECT * FROM VIAGGIO V JOIN SENTIMENT_SCORE_TRAVEL SST " +
                        "JOIN SENTIMENT_SCORE SS WHERE V.LINK = SST.LINK AND SST.ID_SENTIMENT = SS.ID_SENTIMENT " +
                        "AND V.TIPO=" +
                        "'" +
                        tipo +
                        "' and " +
                        "V.CITTA='" +
                        citta +
                        "'";
                        /*"SELECT * " +
                        "FROM VIAGGIO V " +
                        "JOIN SENTIMENT_SCORE_TRAVEL SST " +
                        "JOIN SENTIMENT_SCORE SS " +
                        "WHERE V.LINK = SST.LINK " +
                        " AND SST.ID_SENTIMENT = SS.ID_SENTIMENT " +
                        " AND V.TIPO='"+
                        tipo+
                        "' AND V.CITTA='" +
                        citta +
                        "'";*/
                System.out.println(proviamo);
                ResultSet rs = prov.executeQuery(proviamo);

                while(rs.next())
                {
                    System.out.println("Prova");
                    list.add(new Model_table_principale(rs.getString("NOME_OFFERTA"), rs.getString("CITTA"), rs.getString("TIPO"), rs.getFloat("PERC_MOLTO_POS"), rs.getFloat("PERC_POS"), rs.getFloat("PERC_NEUTRO"), rs.getFloat("PERC_NEGATIVO"), rs.getFloat("PERC_MOLTO_NEG"), rs.getString("LINK")));
                }
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

            col_nome_offerta.setCellValueFactory(new PropertyValueFactory<>("col_nome_offerta"));
            col_citta.setCellValueFactory(new PropertyValueFactory<>("col_citta"));
            col_tipo.setCellValueFactory(new PropertyValueFactory<>("col_tipo"));
            col_molto_positivo.setCellValueFactory(new PropertyValueFactory<>("col_molto_positivo"));
            col_positivo.setCellValueFactory(new PropertyValueFactory<>("col_positivo"));
            col_neutrale.setCellValueFactory(new PropertyValueFactory<>("col_neutrale"));
            col_negativo.setCellValueFactory(new PropertyValueFactory<>("col_negativo"));
            col_molto_negativo.setCellValueFactory(new PropertyValueFactory<>("col_molto_negativo"));
            col_link.setCellValueFactory(new PropertyValueFactory<>("btn_link"));
            col_salva.setCellValueFactory(new PropertyValueFactory<>("btn_salva"));

            id_table.setItems(list);
            //////////////////////////////////////////////////////////////////////////////////////

            /////////// WEB SCRAPING E PRESENTAZIONE DEI DATI NELLA PAGINA
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////
    /////////////////// APERTURA PAGINA BACHECA UTENTE
    //////////////////////////////////////////////////////////////////////////////////////
    public void btn_bacheca_utente_Action(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pagina_bacheca_utente.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Bacheca Utente");
            stage.setScene(new Scene(root1));
            stage.show();
            // ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void btn_logout_Action(ActionEvent actionEvent)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pagina_login.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("MoodTraveling");
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
