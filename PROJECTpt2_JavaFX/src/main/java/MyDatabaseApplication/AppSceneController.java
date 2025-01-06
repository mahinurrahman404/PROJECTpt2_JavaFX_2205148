package MyDatabaseApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AppSceneController {

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

        @FXML
        private TextField username;
        @FXML
        private TextField password;

        public void goto_Title_Scene(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
                stage.setScene(scene);
                stage.show();

        }

    public void Login(ActionEvent event) {
        if(IPL.valid_club(username.getText()) && password.getText().equals("1")) {
            Login_info.setLoggedIn(true);
        }
    }





    //CLIENT LOGIN AND SCENE ----------------------------------------------------------------------------------------

    @FXML
    private TextField client_username;
    @FXML
    private TextField client_password;

    public void client_goto_Title_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Title_Client.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();

    }



    public void clientLogin(ActionEvent event) {
        if (IPL.valid_club(client_username.getText()) && client_password.getText().equals("1")) {
            Login_info_Client.setLoggedIn(true);
            Login_info_Client.setUsername(client_username.getText());
            Login_info_Client.cln = new ClientRunner();
        }
    }



    public void client_goto_Menu_Scene(ActionEvent event) throws IOException {
        if(Login_info_Client.isLoggedIn()) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu_Client.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
    }

    public void client_goto_MyPlayers_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MyPlayers_Client.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void client_goto_SellPlayer_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SellPlayer_Client.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void client_goto_BuyPlayer_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BuyPlayer_Client.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

        //-------------------------------------------------------------------------------------------------------------






        public void goto_Menu_Scene(ActionEvent event) throws IOException {
            if(Login_info.isLoggedIn()) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
                stage.setScene(scene);
                stage.show();
            }
        }

        public void goto_ClubSearch_Scene(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ClubSearch.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
            stage.setScene(scene);
            stage.show();
        }

    public void goto_AddPlayer_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddPlayer.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }



    public void goto_PlayerSearch_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayerSearch.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secNameSearch_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secNameSearch.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secPositionSearch_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secPositionSearch.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secSalarySearch_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secSalarySearch.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secClubCountrySearch_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secClubCountrySearch.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secCountryCount_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secCountryCount.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secMaxAge_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secMaxAge.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secMaxHeight_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secMaxHeight.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secMaxSalary_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secMaxSalary.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void goto_secYearlySalary_Scene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secYearlySalary.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("zstyles.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    //SCENES END ------------------------------------------------------------------------------------------------------





    //SEARCH METHODS
    @FXML
    private TextField nameField;
    @FXML
    private TextArea detailsArea;

    public void nameSearchPlayer(ActionEvent actionEvent) throws IOException {
        String name = nameField.getText();
        List<Player> Result = IPL.name_search(name);
        StringBuilder namedetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such player with this name.";
            namedetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                namedetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsArea.setText(namedetails.toString());
    }



    @FXML
    private TextField lowerSal;
    @FXML
    private TextField higherSal;
    @FXML
    private TextArea detailsAreaSal;

    public void salarySearchPlayer(ActionEvent actionEvent) throws IOException {
        int low = Integer.parseInt(lowerSal.getText());
        int high = Integer.parseInt(higherSal.getText());
        List<Player> Result = IPL.salary_search(low, high);
        StringBuilder saldetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such player with this salary range.";
            saldetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                saldetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsAreaSal.setText(saldetails.toString());
    }



    @FXML
    private TextField pos;
    @FXML
    private TextArea detailsAreaPos;

    public void positionSearchPlayer(ActionEvent actionEvent) throws IOException {
        String position = pos.getText();
        List<Player> Result = IPL.position_search(position);
        StringBuilder posdetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such player with this position.";
            posdetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                posdetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsAreaPos.setText(posdetails.toString());
    }



    @FXML
    private TextField club;
    @FXML
    private TextField country;
    @FXML
    private TextArea detailsAreaCC;

    public void ccSearchPlayer(ActionEvent actionEvent) throws IOException {
        String clubname = club.getText();
        String countryname = country.getText();
        List<Player> Result = IPL.club_country_search(countryname, clubname);
        StringBuilder saldetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such player with this club and country.";
            saldetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                saldetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsAreaCC.setText(saldetails.toString());
    }


    @FXML
    private TextArea detailsAreaCountryCount;

    public void countryCount(ActionEvent actionEvent) throws IOException {
        Map<String, List<String>> countries = IPL.country_wise_count();
        StringBuilder count = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : countries.entrySet()) {
            count.append("Player count from country ").append(entry.getKey()).append(" : ").append(entry.getValue().size()).append("\n");
            count.append("List of players:");
            count.append("\n");
            for (String playername : entry.getValue()) {
                count.append("         -").append(playername);
                count.append("\n");
            }
            count.append("\n");
        }
        detailsAreaCountryCount.setText(count.toString());
    }









    //CLUB SEARCH

    @FXML
    private TextField MaxAge;
    @FXML
    private TextArea detailsAreaMaxAge;

    public void clubMaxAge(ActionEvent actionEvent) throws IOException {
        String age = MaxAge.getText();
        List<Player> Result = IPL.max_age(age);
        StringBuilder MaxAgedetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such club.";
            MaxAgedetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                MaxAgedetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsAreaMaxAge.setText(MaxAgedetails.toString());
    }



    @FXML
    private TextField MaxSal;
    @FXML
    private TextArea detailsAreaMaxSal;

    public void clubMaxSal(ActionEvent actionEvent) throws IOException {
        String sal = MaxSal.getText();
        List<Player> Result = IPL.max_salary(sal);
        StringBuilder MaxSaldetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such club.";
            MaxSaldetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                MaxSaldetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsAreaMaxSal.setText(MaxSaldetails.toString());
    }


    @FXML
    private TextField MaxH;
    @FXML
    private TextArea detailsAreaMaxH;

    public void clubMaxH(ActionEvent actionEvent) throws IOException {
        String h = MaxH.getText();
        List<Player> Result = IPL.max_height(h);
        StringBuilder MaxHdetails = new StringBuilder();
        if (Result.isEmpty()) {
            String error = "No such club.";
            MaxHdetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                MaxHdetails.append(Result.get(i).toString()).append("\n");
            }
        }
        detailsAreaMaxH.setText(MaxHdetails.toString());
    }


    @FXML
    private TextField Yearly;
    @FXML
    private TextArea detailsAreaYearly;

    public void clubYearlySal(ActionEvent actionEvent) throws IOException {
        String yearlysal = Yearly.getText();
        long Result = 0L;
        Result = IPL.yearly_salary(yearlysal);
        StringBuilder MaxHdetails = new StringBuilder();
        String error;
        if (Result == 0) {
            error = "No such club.";
        } else {
            error = "The total yearly salary for this club is " + Result + ".";
        }
        MaxHdetails.append(error).append("\n");
        detailsAreaYearly.setText(MaxHdetails.toString());
    }





    //ADDPLAYR
    @FXML
    private TextField add_name;
    @FXML
    private TextField add_age;
    @FXML
    private TextField add_salary;
    @FXML
    private TextField add_club;
    @FXML
    private TextField add_country;
    @FXML
    private TextField add_jersey;
    @FXML
    private TextField add_position;
    @FXML
    private TextField add_height;

    public void addPlayer(ActionEvent actionEvent) throws IOException {
        String name = add_name.getText();
        int age = Integer.parseInt(add_age.getText());
        Long sal = Long.parseLong(add_salary.getText());
        double height = Double.parseDouble(add_height.getText());
        String country = add_country.getText();
        String jersey = add_jersey.getText();
        String position = add_position.getText();
        String club = add_club.getText();
        Player temp = new Player(name,country,age,height,club,position,jersey,sal);
        IPL.addPlayer(temp);
        FileOperations.Save_Players_Info(IPL);
    }








    //CLIENT METHODS-----------------------------------------------------------------------------------------------


    //SHOWING PLAYERS OWNED BY CLIENT
    @FXML
    private TextArea client_detailsAreaAvailablePlayers;

    public void AvailablePlayers(ActionEvent actionEvent) throws IOException {
        String clubname = Login_info_Client.getUsername();
        List<Player> Result = IPL.AvailablePlayers(clubname);
        StringBuilder playerdetails = new StringBuilder();

        if (Result.isEmpty()) {
            String error = "No players";
            playerdetails.append(error).append("\n");
        } else {
            for (int i = 0; i < Result.size(); i++) {
                playerdetails.append(Result.get(i).toString()).append("\n");
            }
        }

        client_detailsAreaAvailablePlayers.setText(playerdetails.toString());
    }



    //SHOW AVAILABLE FOR BUYING PLAYERS
    @FXML
    private TextArea client_serverDataShow;

    public void RequestData(ActionEvent event) throws IOException {
        StringBuilder availablePlayersDetails = new StringBuilder();

        if (Login_info_Client.cln != null) {
            String response = Login_info_Client.cln.sendMessage("GET_AVAILABLE_PLAYERS");
            availablePlayersDetails.append(response).append("\n");
        } else {
            availablePlayersDetails.append("Client not connected to the server.\n");
        }

        client_serverDataShow.setText(availablePlayersDetails.toString());
    }



    //MAKING PLAYERS UP FOR SALE
    @FXML
    private TextField client_UFSPlayer;
    @FXML
    private TextArea client_detailsUFSPlayer;

    public void SellMyPlayer(ActionEvent actionEvent) {
        System.out.println(Login_info_Client.cln.isConnected());
        String name = client_UFSPlayer.getText();
        name = IPL.isMyPlayer(name, Login_info_Client.getUsername());
        StringBuilder sellDetails = new StringBuilder();

        if (name.equals("false")) {
            String error = "No such player";
            sellDetails.append(error).append("\n");
        } else {
            if (Login_info_Client.cln != null && Login_info_Client.cln.isConnected()) {
                String serverResponse = Login_info_Client.cln.sendMessage("SELL_PLAYER " + name);
                sellDetails.append(serverResponse).append("\n");
            } else {
                sellDetails.append("Client not connected to the server.\n");
            }
        }

        client_detailsUFSPlayer.setText(sellDetails.toString());
    }



    //BUY BY TRANSFERRING OWNERSHIP AND CHANGING PLAYERMARKET
    @FXML
    private TextField client_BuyPlayer;
    @FXML
    private TextArea client_BuyPrompt;

    public void BuyMyPlayer(ActionEvent actionEvent) throws IOException {
        String name = client_BuyPlayer.getText();
        StringBuilder buyDetails = new StringBuilder();

        if (name.isEmpty()) {
            buyDetails.append("Player name cannot be empty.\n");
        } else {
            if (Login_info_Client.cln != null) {
                String serverResponse = Login_info_Client.cln.sendMessage("BUY_PLAYER " + name);
                buyDetails.append(serverResponse).append("\n");
            } else {
                buyDetails.append("Client not connected to the server.\n");
            }
        }

        IPL.TransferOwnership(name, Login_info_Client.getUsername());
        FileOperations.Save_Players_Info(IPL);
        client_BuyPrompt.setText(buyDetails.toString());
    }




    //----------------------------------------------------------------------------------------------------------------------

}

