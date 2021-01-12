/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;


import ehu.isad.controller.ui.AdminKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    private Parent AdminUI;

    private Stage stage;

    private AdminKud adminKud;


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("PMA");
        stage.setScene(new Scene(AdminUI));
        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderAdmin = new FXMLLoader(getClass().getResource("/admin.fxml"));
        AdminUI = (Parent) loaderAdmin.load();
        adminKud = loaderAdmin.getController();
        adminKud.setMainApp(this);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
