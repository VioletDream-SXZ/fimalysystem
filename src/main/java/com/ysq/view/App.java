package com.ysq.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class App extends Application {
    private static final App instance = new App();

    private Stage primaryStage;

    public static App getInstance() {
        return instance;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.getInstance().setPrimaryStage(primaryStage);
        App.getInstance().showLoginUi();
    }

    @Override
    public void init() throws  Exception {
        super.init();
        System.out.println("init");
    }

    public void showLoginUi() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/login.fxml")));
            Scene scene = new Scene(root, 761, 523);
            primaryStage.setTitle("用户注册");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showRegisterUi() {

    }
}
