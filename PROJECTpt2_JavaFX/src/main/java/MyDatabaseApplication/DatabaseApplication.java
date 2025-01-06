package MyDatabaseApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DatabaseApplication extends Application {


    public static PlayerList IPL = new PlayerList();

    public static void main(String[] args) throws IOException {
        FileOperations.Get_Inputs_Text(IPL);
        launch();
    }


    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title.fxml")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());


                //STAGE MODIFICATION
            Image icon = new Image("cricicon.png");
            stage.getIcons().add(icon);
            stage.setTitle("CrikData");



            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}