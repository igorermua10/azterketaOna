package ehu.isad.controller.ui;
import ehu.isad.Main;
import java.net.URL;
import java.util.ResourceBundle;

import ehu.isad.Mezuak;
import ehu.isad.controller.db.AzterketaDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

public class MainKud {
    private Main main;
    public void setMainApp (Main main){

        this.main = main;
    }

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableView<Mezuak> tabla;

        @FXML
        private TableColumn<?, ?> nork;

        @FXML
        private TableColumn<?, ?> nori;

        @FXML
        private TableColumn<?, ?> mezu;

        @FXML
        private Button btn_gorde;

        @FXML
        void onClick(ActionEvent event) {

        }

    @FXML
    private final ObservableList<Mezuak> mezuak = FXCollections.observableArrayList(
            AzterketaDBKud.getAzterketakud().getMezuak());
    void initialize() {
        tabla.setEditable(true);

        tabla.setItems(mezuak);


        }


    public void onCheck(ActionEvent actionEvent) {
    }
}


