package sample.Pattern.Factory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classi.Database;
import sample.Classi.Model_table_utente;
import sample.Controller_pagina_login;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Bacheca_utente implements Bacheca
{
    @FXML private TableView<Contenuto_utente> id_table;
    @FXML private TableColumn<Contenuto_utente, String> col_nome_offerta, col_citta, col_tipo;
    @FXML private TableColumn<Contenuto_utente, Button> col_elimina;

    ObservableList<Contenuto_utente> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        Database prova = Database.getInstance();
        Connection con = prova.getConnection();

        Controller_pagina_login e = Controller_pagina_login.getInstance();
        String ss = e.getUsername_inserito().toLowerCase();

        try
        {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM ha H JOIN viaggio V ON H.LINK=V.LINK WHERE EMAIL="+ "'" + ss + "'");

            while(rs.next())
            {
                list.add(new Contenuto_utente(rs.getString("NOME_OFFERTA"), rs.getString("CITTA"), rs.getString("TIPO"), rs.getString("LINK"), ss));
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        col_nome_offerta.setCellValueFactory(new PropertyValueFactory<>("col_nome_offerta"));
        col_citta.setCellValueFactory(new PropertyValueFactory<>("col_citta"));
        col_tipo.setCellValueFactory(new PropertyValueFactory<>("col_tipo"));
        col_elimina.setCellValueFactory(new PropertyValueFactory<>("btn_elimina"));

        id_table.setItems(list);
    }
}
