package MVC;

import COMMAND.Command;
import COMMAND.LoginCommand;
import COMMAND.SignUpCommand;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scene1View {
    private model1 model;
    private SceneController controller;
    Label usernameLabel;
    TextField usernameTextField;
    Label passwordLabel;
    PasswordField passwordField;
    Button loginButton;
    Button signUpButton;
    VBox vBox;

    public Scene1View(model1 model) {
        this.model = model;
        initialize();
    }

    private void initialize() {
        // Impostazione dello sfondo per il VBox
        vBox = new VBox(10);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(new Insets(20));

        usernameLabel = new Label("USERNAME");
        usernameTextField = new TextField();
        passwordLabel = new Label("PASSWORD");
        passwordField = new PasswordField();
        loginButton = new Button("Accedi!");
        signUpButton = new Button("Registrati!");
        usernameTextField.setPrefWidth(200); // Imposta la larghezza desiderata
        usernameTextField.setMaxWidth(200); // Imposta la larghezza massima
        usernameTextField.setMinHeight(30); // Imposta l'altezza minima
        passwordField.setPrefWidth(200); // Imposta la larghezza desiderata
        passwordField.setMaxWidth(200); // Imposta la larghezza massima
        passwordField.setMinHeight(30); // Imposta l'altezza minima

        // Set up the layout
        vBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton,
                signUpButton);

        controller = new SceneController(model);

        loginButton.setOnAction(event -> {
            model.setUsername(usernameTextField.getText());
            model.setPassword(passwordField.getText());

            Command loginCommand = new LoginCommand(controller, event);
            loginCommand.execute();
        });

        signUpButton.setOnAction(event -> {
            model.setUsername(usernameTextField.getText());
            model.setPassword(passwordField.getText());

            Command signupCommand = new SignUpCommand(controller, event);
            signupCommand.execute();
        });

        // Style
        usernameLabel.setStyle("-fx-font-size: 14px;");
        passwordLabel.setStyle("-fx-font-size: 14px;");
        loginButton.setStyle("-fx-font-size: 14px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        signUpButton.setStyle("-fx-font-size: 14px; -fx-background-color: #008CBA; -fx-text-fill: white;");
        vBox.setStyle("-fx-background-color: #ADD8E6; -fx-border-color: #ccc; -fx-border-width: 1px;");
        vBox.setMinWidth(300);
        vBox.setSpacing(15);
    }

    public void showView() {
        Stage stage = new Stage();
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        stage.setScene(new Scene(vBox, 800, 600));
        stage.show();
    }
}
