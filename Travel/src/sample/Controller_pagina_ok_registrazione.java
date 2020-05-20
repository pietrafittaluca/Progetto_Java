package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_pagina_ok_registrazione
{
    @FXML
    private Button button_complete;

    public void btn_complete_Action(ActionEvent actionEvent)
    {
        Stage stage2 = (Stage) button_complete.getScene().getWindow();
        stage2.close();
    }
}
