package MVC;

import COMMAND.BackCommand;
import COMMAND.Command;
import COMMAND.PlayGameCommand;
import OBSERVER.Observable;
import OBSERVER.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scene2View extends AnchorPane implements Observer {

    private int numPlayers = 0;
    private model1 model;
    private Label benvenuto;
    private MenuButton menuButton;
    private ChoiceBox<Integer> choiceBox;
    private Label numeroGiocatori;
    private Button playButton;
    private Button backButton;

    public Scene2View(model1 model) {
        this.model = model;
        this.model.addObserver(this);
        initialize();
    }

    private void initialize() {
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefSize(800, 600);

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        benvenuto = new Label("Ciao " + model.getUsername()+" !");
        benvenuto.setStyle("-fx-font-size: 24; -fx-text-fill: #000000;");

        backButton = new Button("<-");
        backButton.setStyle("-fx-background-color: red; -fx-font-size: 14;");

        menuButton = new MenuButton("Seleziona le categorie:");
        menuButton.setStyle("-fx-font-size: 16;");

        CheckMenuItem cat1Item = new CheckMenuItem("Nome");
        CheckMenuItem cat2Item = new CheckMenuItem("Cose");
        CheckMenuItem cat3Item = new CheckMenuItem("Città");
        CheckMenuItem cat4Item = new CheckMenuItem("Frutta");
        CheckMenuItem cat5Item = new CheckMenuItem("Verbi");
        CheckMenuItem cat6Item = new CheckMenuItem("Animali");
        CheckMenuItem cat7Item = new CheckMenuItem("Piante");
        CheckMenuItem cat8Item = new CheckMenuItem("Cantanti");
        CheckMenuItem cat9Item = new CheckMenuItem("Nazioni");
        CheckMenuItem cat10Item = new CheckMenuItem("Mestieri");
        CheckMenuItem cat11Item = new CheckMenuItem("Celebrità");

        choiceBox = new ChoiceBox<>();
        ObservableList<Integer> numPlayersList = FXCollections.observableArrayList(1, 2, 3);
        choiceBox.setItems(numPlayersList);

        numeroGiocatori = new Label("Numero di Giocatori Avversari:");
        numeroGiocatori.setStyle("-fx-font-size: 16;");

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                numPlayers = newValue;
            }
        });

        playButton = new Button("PLAY");
        playButton.setStyle("-fx-background-color: #2ECC71; -fx-font-size: 18;");
        VBox.setMargin(playButton, new Insets(100, 0, 0, 0));


        menuButton.getItems().addAll(cat1Item, cat2Item, cat3Item, cat4Item, cat5Item, cat6Item, cat7Item, cat8Item, cat9Item, cat10Item, cat11Item);

        vbox.getChildren().addAll(benvenuto, menuButton, numeroGiocatori, choiceBox, playButton);
        AnchorPane.setTopAnchor(vbox, 0.0);
        AnchorPane.setBottomAnchor(vbox, 0.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);
        getChildren().add(vbox);

        AnchorPane.setTopAnchor(backButton, 10.0);
        AnchorPane.setLeftAnchor(backButton, 10.0);
        getChildren().add(backButton);

        Scene2Controller controller = new Scene2Controller(model);

        cat1Item.setOnAction(controller::setCat1);
        cat2Item.setOnAction(controller::setCat2);
        cat3Item.setOnAction(controller::setCat3);
        cat4Item.setOnAction(controller::setCat4);
        cat5Item.setOnAction(controller::setCat5);
        cat6Item.setOnAction(controller::setCat6);
        cat7Item.setOnAction(controller::setCat7);
        cat8Item.setOnAction(controller::setCat8);
        cat9Item.setOnAction(controller::setCat9);
        cat10Item.setOnAction(controller::setCat10);
        cat11Item.setOnAction(controller::setCat11);

        backButton.setOnAction(event -> {
            Command backcommand = new BackCommand(controller, event);
            backcommand.execute();
        });

        playButton.setOnAction(event -> {
            Command playgamecommand = new PlayGameCommand(controller, numPlayers, event);
            playgamecommand.execute();
        });
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof model1) {
            updateView();
        }
    }

    private void updateView() {
        benvenuto.setText("Benvenuto " + model.getUsername());
    }

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this));
        stage.show();
    }
}
