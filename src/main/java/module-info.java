module com.cutecow.project.cutecow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cutecow.project.cutecow to javafx.fxml;
    exports com.cutecow.project.cutecow;
}