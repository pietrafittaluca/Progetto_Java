package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.xml.dtm.ref.DTMAxisIteratorBase;
import sample.Classi.Database;
import sample.Classi.ScheduledTask;

import java.util.Timer;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("pagina_login.fxml"));
        primaryStage.setTitle("MoodTraveling");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    ////////// MAIN
    ///////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws Exception
    {
        ///////////////////////////////////////////////////////////////////////////////////
        /*ESEMPIO ESECUZIONE TASK*/
        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
        time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs
        ///////////////////////////////////////////////////////////////////////////////////

        /*Database prova = Database.getInstance();
        prova.getConnection();
        prova.insertViaggio("nome_offerta_prova", "prova.prova.it", "prova_citta", "Soggiorno");
        prova.insertViaggio_SentimentScore("prova.prova.it", 1.5f, 1.5f, 1.5f,1.5f, 1.5f);

        prova.insertRecensione("+++prova+++", "prova.prova.it");
        prova.insertRecensione_SentimentScore(0.5f, 0.5f, 0.5f, 0.5f, 0.5f);*/

        launch(args);
    }
}