package MVC;

import COMMAND.Back1Command;
import COMMAND.Command;
import COMMAND.SignUp2Command;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scene3View extends AnchorPane {

    private model1 model;
    private VBox vbox;
    private Label usernameLabel;
    private TextField username;
    private Label passwordLabel;
    private TextField password;
    private Label mailLabel;
    private TextField mail;
    private Button signupButton;
    private Button backButton;
    Scene3controller controller;

    public Scene3View(model1 model) {
        this.model = model;
        initialize();
    }

    private void initialize() {

        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        backButton = new Button("<-");
        backButton.setLayoutX(20);
        backButton.setLayoutY(20);
        backButton.setStyle("-fx-background-color: red; -fx-font-size: 14;");

        usernameLabel = new Label("Username");
        username = new TextField();
        username.setPrefWidth(200);
        username.setMaxWidth(200);

        passwordLabel = new Label("Password");
        password = new TextField();
        password.setPrefWidth(200);
        password.setMaxWidth(200);

        mailLabel = new Label("E-Mail");
        mail = new TextField();
        mail.setPrefWidth(200);
        mail.setMaxWidth(200);

        signupButton = new Button("Registrati!");
        signupButton.setStyle("-fx-background-color: lightgreen; -fx-font-size: 18;");

        vbox.getChildren().addAll(usernameLabel, username, passwordLabel, password, mailLabel, mail, signupButton);
        getChildren().addAll(vbox, backButton);

        AnchorPane.setTopAnchor(vbox, 100.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);

        controller = new Scene3controller(model);

        signupButton.setOnAction(event -> {
            model.setUsername(username.getText());
            model.setPassword(password.getText());
            model.setMail(mail.getText());
            Command signup2command = new SignUp2Command(controller, event);
            signup2command.execute();
        });

        backButton.setOnAction(event -> {
            Command back1command = new Back1Command(controller, event);
            back1command.execute();
        });
    }

    public void showView1() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}
