package MyDatabaseApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ServerController {

    private PlayerList IPL;
    @FXML

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
        // Initialize the PlayerList and load data
        IPL = new PlayerList();
        try {
            FileOperations.Get_Inputs_Text(IPL);
            //System.out.println("PlayerList successfully loaded.");
        } catch (IOException e) {
            System.err.println("Error loading PlayerList: " + e.getMessage());
        }
    }


    public void goto_Title_Scene_Server(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title_Server.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    public void goto_Menu_Scene_Server(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Server_On_Scene.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    public void StartServer(ActionEvent event) throws IOException {
        new Thread(() -> ServerRunner.main()).start();
        goto_Menu_Scene_Server(event);
    }



}

