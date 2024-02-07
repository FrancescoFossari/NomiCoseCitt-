package MVC;

import BUILDER.Tabella;
import COMMAND.Back2Command;
import COMMAND.Command;
import COMMAND.RLCommand;
import COMMAND.StartCommand;
import COMMAND.SubmitCommand;
import COMMAND.TerminaCommand;
import OBSERVER.Observable;
import OBSERVER.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScene extends AnchorPane implements Observer{
    private TableView<Tabella> GG;
    private HBox Hbox;
    private Button Start;
    private Label Lettera;
    private Button RL;
    private Button Submit;
    private Button Termina;
    private VBox v1;
    private Text TR;
    private Label Nominativo;
    private Button Back2;
    


    model1 model;
    MainSceneController controller;

    public MainScene(model1 model) {
        this.model=model;
        this.model.addObserver(this);
        initialize();

    }

    private void initialize() {
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefSize(800, 600);
        
        Nominativo = new Label(model.getUsername());
        Nominativo.setLayoutX(66);
        Nominativo.setLayoutY(75);
        Nominativo.setStyle("-fx-font-size: 18; -fx-text-fill: #000000;");

        Back2 = new Button("<-");
        Back2.setLayoutX(0.0);
        Back2.setLayoutY(0.0);
        Back2.setStyle("-fx-background-color: red; -fx-font-size: 14;");



        GG = new TableView<Tabella>();
        GG.setLayoutX(66);
        GG.setLayoutY(101);
        GG.setPrefHeight(135);
        GG.setVisible(false);
        
       

        Hbox = new HBox();
        Hbox.setAlignment(Pos.CENTER);
        Hbox.setLayoutX(3);
        Hbox.setLayoutY(478);
        Hbox.setPrefHeight(45);
        Hbox.setPrefWidth(779);
        
        Lettera = new Label();
        Lettera.setLayoutX(503);
        Lettera.setLayoutY(24);
        Lettera.setPrefHeight(57);
        Lettera.setPrefWidth(77);
        Lettera.setFont(new Font("Bell MT Bold", 30));

        v1 = new VBox();
        v1.setLayoutX(66);
        v1.setLayoutY(259);
        v1.setPrefHeight(209);
        v1.setPrefWidth(255);

        TR = new Text();
        TR.setLayoutX(359);
        TR.setLayoutY(67);
        TR.setFont(new Font(36));
        TR.setVisible(false);

        RL = new Button("Lettera");
        RL.setLayoutX(685);
        RL.setLayoutY(23);
        RL.setVisible(false);
        RL.setStyle("-fx-font-size: 14px; -fx-background-color: #008CBA; -fx-text-fill: white;");
        
        Termina = new Button("Termina");
        Termina.setLayoutX(597);
        Termina.setLayoutY(23);
        Termina.setStyle("-fx-background-color: red; -fx-font-size: 14;");
        
        
        Start = new Button("INIZIA");
        Start.setLayoutX(354.0);
        Start.setLayoutY(268.0);
        Start.setVisible(true);
        Start.setStyle("-fx-background-color: #2ECC71; -fx-font-size: 18;");

        controller = new MainSceneController(GG,Hbox,v1,Lettera,TR,RL,Start,model);
        
        Submit = new Button("Conferma");
        Submit.setLayoutX(354.0);
        Submit.setLayoutY(523.0);
        Submit.setStyle("-fx-font-size: 14px; -fx-background-color: #008CBA; -fx-text-fill: white;");
    
        
        Start.setOnAction(event -> {Command startcommand = new StartCommand(controller, event);
        startcommand.execute(); 
        });

        Submit.setOnAction(event -> {Command submitcommand = new SubmitCommand(controller, event);
            submitcommand.execute(); 
            });
       
        RL.setOnAction(event -> {Command rlcommand = new RLCommand(controller, event);
            rlcommand.execute(); 
            });
            
        Termina.setOnAction(event -> {Command terminacommand = new TerminaCommand(controller, event);
            terminacommand.execute(); 
            });

        Back2.setOnAction(event -> {Command back2command = new Back2Command(controller, event);
        back2command.execute(); 
        });


        getChildren().addAll(GG, Hbox, Start, Lettera, RL, Submit, v1, TR, Termina, Nominativo,Back2);

    }
     @Override
    public void update(Observable observable) {
       
        if (observable instanceof model1) {
            updateView();
        }
    }

    private void updateView() {
        Nominativo.setText(model.getUsername());
    }
   

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}
