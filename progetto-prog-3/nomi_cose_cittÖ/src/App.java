import MVC.AppController;
import MVC.model1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos; // Import necessario per utilizzare Pos
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    private Button nextButton;
    private model1 model;
    private AppController controller;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nomi, Cose, Citta e altro");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));


        // Creazione del testo del regolamento
        Text title = new Text("Regolamento del Gioco Nomi, Cose e Città:");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        TextArea rulesTextArea = new TextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setWrapText(true);
        rulesTextArea.setText(
                "1. Scelta delle Categorie:\n" +
                        "   - L'amministratore del gioco seleziona le categorie da utilizzare durante la partita...\n\n" +
                        "2. Creazione della Griglia del Giocatore:\n" +
                        "   - Ogni giocatore riceve un foglio di carta con una griglia...\n\n" +
                        "3. Estrazione della Lettera:\n" +
                        "   - Inizia ogni partita con l'estrazione casuale di una lettera...\n\n" +
                        "4. Fase di Gioco:\n" +
                        "   - I giocatori devono compilare la loro griglia trovando una parola per ogni categoria...\n\n" +
                        "5. Calcolo dei Punti:\n" +
                        "   - Il computer assegna automaticamente punteggi alle parole secondo le regole specificate...\n\n" +
                        "6. Ricerca delle Parole nel Dizionario:\n" +
                        "   - Il computer può utilizzare due strategie per la ricerca delle parole nel dizionario...\n\n" +
                        "7. Nuova Lettera e Ripetizione del Gioco:\n" +
                        "   - Dopo il calcolo dei punti, si estrae casualmente una nuova lettera e si ripete il gioco...\n\n" +
                        "8. Visualizzazione delle Informazioni:\n" +
                        "   - L'applicazione consente di visualizzare le informazioni dei giocatori, la classifica parziale e totale dei vincitori di tutte le partite...\n\n" +
                        "9. Vincitore Finale:\n" +
                        "   - Il vincitore complessivo sarà determinato alla fine di tutte le partite..."
        );

        // Impostazione della dimensione della TextArea
        rulesTextArea.setPrefRowCount(20);
        rulesTextArea.setPrefColumnCount(50);

        // Creazione del bottone "Next"
        nextButton = new Button("Vai Avanti!");
        nextButton.setPrefWidth(100);
        nextButton.setStyle("-fx-font-size: 14px; -fx-background-color: #008CBA; -fx-text-fill: white;");

        // Creazione del layout verticale per il titolo del regolamento, il testo del regolamento e il bottone "Next"
        VBox centerLayout = new VBox(20);
        centerLayout.getChildren().addAll(title, rulesTextArea, nextButton);
        centerLayout.setPadding(new Insets(0, 20, 0, 20)); // Aggiunto padding per centrare il bottone
        centerLayout.setAlignment(Pos.CENTER); // Centra il contenuto della VBox

        // Impostazione del contenuto scorrevole per la VBox
        ScrollPane scrollPane = new ScrollPane(centerLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Disposizione degli elementi nella root BorderPane
        root.setCenter(scrollPane);

        // Inizializzazione del modello e del controller
        model = new model1();
        controller = new AppController(model);

        // Impostazione del click handler per il bottone "Next"
        nextButton.setOnAction(controller::Next);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
