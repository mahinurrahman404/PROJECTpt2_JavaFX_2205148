module com.example.project_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens MyDatabaseApplication to javafx.fxml;
    exports MyDatabaseApplication;
}