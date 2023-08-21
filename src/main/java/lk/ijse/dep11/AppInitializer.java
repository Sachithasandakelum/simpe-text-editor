package lk.ijse.dep11;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Java-FX text editor app");

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        mainScene.setFill(Color.TRANSPARENT);

        primaryStage.centerOnScreen();
        primaryStage.show();


        Stage textEditorStage = new Stage();

        AnchorPane textEditorRoot = FXMLLoader.load(getClass().getResource("/view/TextEditor.fxml"));
        Scene textEditorScene = new Scene(textEditorRoot);
        textEditorStage.setScene(textEditorScene);
        textEditorStage.setTitle("Text Editor");
        textEditorStage.sizeToScene();

        PauseTransition pause = new PauseTransition(Duration.millis(2000));
        pause.setOnFinished(event -> {
            textEditorStage.show(); // Show the text editor stage after the delay
            primaryStage.close();
        });

        pause.play();

//        textEditorStage.show();
//
//        primaryStage.close();

    }
}
