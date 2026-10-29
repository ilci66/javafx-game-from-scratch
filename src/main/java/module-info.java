module com.ilker.gamefromscratch {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.ilker.gamefromscratch to javafx.fxml;
    exports com.ilker.gamefromscratch;
}