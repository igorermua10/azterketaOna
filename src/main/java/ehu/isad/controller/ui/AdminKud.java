package ehu.isad.controller.ui;

import ehu.isad.Datuak;
import ehu.isad.Main;
import ehu.isad.MessageDigestForUrl;
import ehu.isad.controller.db.AzterketaDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;

public class AdminKud implements Initializable {
    private Main main;
    public void setMainApp (Main main){

        this.main = main;
    }

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableView<Datuak> tabla;

        @FXML
        private TableColumn<Datuak, String> url;

        @FXML
        private TableColumn<Datuak, String> md5;

        @FXML
        private TableColumn<Datuak, String> version;

        @FXML
        private TextField sartuURL;

        @FXML
        private Button btn_check;

        @FXML
        void onCheck(ActionEvent event) throws IOException, NoSuchAlgorithmException {
           String web= sartuURL.getText()+"/README";
           String md5= MessageDigestForUrl.md5Itzuli(web);
           String bertsioa= AzterketaDBKud.getAzterketakud().getBertsioa(md5);
           if (bertsioa!=null){
               String url=sartuURL.getText();
               Datuak erakutsi=new Datuak();
               erakutsi.setMd5(md5);
               erakutsi.setUrl(url);
               erakutsi.setVersion(bertsioa);

               List<Herrialdea> herrialdeLista = EurobisioaKud.getInstance().lortuHerrialdeak();
               ObservableList<Herrialdea> herrialdeak = FXCollections.observableArrayList(herrialdeLista);
               cmbx_herrialdeak.setItems(herrialdeak);

           }



        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
