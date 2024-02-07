package MVC;
import BUILDER.BuilderTabella;
import BUILDER.Tabella;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn; 
import javafx.scene.control.TableView;
import javafx.scene.control.TextField; 
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import PROTOTYPE.CustomTables;
import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;

public class MainSceneController {

    private model1 model;
    private TableView<Tabella> GG;
    private HBox Hbox;
    private Label Lettera;
    private Button RL;
    private VBox v1;
    private Text TR;
    private Button Start;
    private boolean ColTot  = true;
    private boolean ColNome;
    private boolean ColCosa;
    private boolean ColCitta;
    private boolean ColFrutta;
    private boolean ColVerbi;
    private boolean ColAnimali;
    private boolean ColPiante;
    private boolean ColCantanti;
    private boolean ColNazioni;
    private boolean ColMestieri;
    private boolean ColCelebrita;
    private boolean RandomCharButton = true;
    private List<TableView<Tabella>> clonedTableViews = new ArrayList<>();
    private int numPartite = 0;
    private int cont = 0;
    private int[] arrayPunteggi;
    private char LetteraCasuale;
    private int numTab = 0;
    private Label label1 = new Label("Nome: ");
    private Label label2 = new Label("Cose: ");
    private Label label3 = new Label("Cittá: ");
    private Label label4 = new Label("Frutta: ");
    private Label label5 = new Label("Verbi: ");
    private Label label6 = new Label("Animali: ");
    private Label label7 = new Label("Piante: ");
    private Label label8 = new Label("Cantanti: ");
    private Label label9 = new Label("Nazioni: ");
    private Label label10 = new Label("Mestieri: ");
    private Label label11 = new Label("Celebritá: ");
    private TextField Campo1 = new TextField();
    private TextField Campo2 = new TextField();
    private TextField Campo3 = new TextField();
    private TextField Campo4 = new TextField();
    private TextField Campo5 = new TextField();
    private TextField Campo6 = new TextField();
    private TextField Campo7 = new TextField();
    private TextField Campo8 = new TextField();
    private TextField Campo9 = new TextField();
    private TextField Campo10 = new TextField();
    private TextField Campo11 = new TextField();

    
    

    private int countdown = 20;
    private Timeline timeline;
    private boolean running;
    private boolean sminchiamento = false ;
    private boolean sminchiamento2 = false ;
public MainSceneController(TableView<Tabella> GG, HBox Hbox, VBox v1, Label Lettera,Text TR,Button RL,Button Start,model1 model) {
    this.GG = GG;
    this.Hbox = Hbox;
    this.v1 = v1;
    this.Lettera = Lettera;
    this.TR =TR;
    this.RL = RL;
    this.Start = Start;
    this.model = model;
}

    
    public void startGame(ActionEvent event) {

       Start.setVisible(false);
       RL.setVisible(true);
       GG.setVisible(true);

       ColNome = model.getCat1();
       ColCosa = model.getCat2();
       ColCitta = model.getCat3();
       ColFrutta = model.getCat4();
       ColVerbi = model.getCat5();
       ColAnimali = model.getCat6();
       ColPiante = model.getCat7();
       ColCantanti = model.getCat8();
       ColNazioni = model.getCat9();
       ColMestieri = model.getCat10();
       ColCelebrita = model.getCat11();
       
       numTab = model.getNumPlayers();
      
       timeline = new Timeline(new KeyFrame(Duration.seconds(1.0), this::updateTimer));
       timeline.setCycleCount(Timeline.INDEFINITE);
       arrayPunteggi = new int[numTab+1];
       

       for (int i = 0; i < arrayPunteggi.length; i++) {
        arrayPunteggi[i] = 0;
       
    }

   
        
      


       TR.setText(String.valueOf(countdown));

       TableColumn<Tabella, String> TOT = new TableColumn<>("tot");
        TableColumn<Tabella, String> Cnome = new TableColumn<>("nome");
        TableColumn<Tabella, String> Ccose = new TableColumn<>("cosa");
        TableColumn<Tabella, String> Ccitta = new TableColumn<>("citta");
        TableColumn<Tabella, String> Cfrutta = new TableColumn<>("frutta");
        TableColumn<Tabella, String> Cverbi = new TableColumn<>("verbi");
        TableColumn<Tabella, String> Canimali = new TableColumn<>("animali");
        TableColumn<Tabella, String> Cpiante = new TableColumn<>("piante");
        TableColumn<Tabella, String> Ccantanti = new TableColumn<>("cantanti");
        TableColumn<Tabella, String> Cnazioni = new TableColumn<>("nazioni");
        TableColumn<Tabella, String> Cmestieri = new TableColumn<>("mestieri");
        TableColumn<Tabella, String> Ccelebrita = new TableColumn<>("celebrita");
                       
        double nuovaLarghezza = 0.0 ;

        if(ColNome){
            
            
            Cnome.setCellValueFactory(new PropertyValueFactory<Tabella, String>("nome"));
    
            GG.getColumns().add(Cnome);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label1,Campo1);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cnome.setMinWidth(nuovaLarghezza / cont);   
            
        }
    
            if(ColCosa){
            
             Ccose.setCellValueFactory(new PropertyValueFactory<Tabella, String>("cosa"));
             GG.getColumns().add(Ccose);
    
           nuovaLarghezza += 100.0; 
            Hbox.getChildren().addAll(label2,Campo2);
    
            cont += 1;
    
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            Ccose.setMinWidth(nuovaLarghezza / cont);
        }
    
    
        if(ColCitta){
            
            Ccitta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("citta"));
             GG.getColumns().add(Ccitta);
    
         nuovaLarghezza += 100.0; 
            Hbox.getChildren().addAll(label3,Campo3);

             cont += 1;
    
              GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
            Ccitta.setMinWidth(nuovaLarghezza / cont);
        }
    
    
         if(ColFrutta){
            
             Cfrutta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("frutta"));
             GG.getColumns().add(Cfrutta);
    
            nuovaLarghezza += 100.0; 
            Hbox.getChildren().addAll(label4,Campo4);
    
            cont += 1;
    
            
            GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
            Cfrutta.setMinWidth(nuovaLarghezza / cont);
        }



        if(ColVerbi){
            
            
            Cverbi.setCellValueFactory(new PropertyValueFactory<Tabella, String>("verbi"));
    
            GG.getColumns().add(Cverbi);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label5,Campo5);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cverbi.setMinWidth(nuovaLarghezza / cont);   
            
        }

        if(ColAnimali){
            
            
            Canimali.setCellValueFactory(new PropertyValueFactory<Tabella, String>("animali"));
    
            GG.getColumns().add(Canimali);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label6,Campo6);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Canimali.setMinWidth(nuovaLarghezza / cont);   
            
        }

        if(ColPiante){
            
            
            Cpiante.setCellValueFactory(new PropertyValueFactory<Tabella, String>("piante"));
    
            GG.getColumns().add(Cpiante);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label7,Campo7);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cpiante.setMinWidth(nuovaLarghezza / cont);   
            
        }

        if(ColCantanti){
            
            
            Ccantanti.setCellValueFactory(new PropertyValueFactory<Tabella, String>("cantanti"));
    
            GG.getColumns().add(Ccantanti);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label8,Campo8);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Ccantanti.setMinWidth(nuovaLarghezza / cont);   
            
        }

        if(ColNazioni == true){
            
            
            Cnazioni.setCellValueFactory(new PropertyValueFactory<Tabella, String>("nazioni"));
    
            GG.getColumns().add(Cnazioni);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label9,Campo9);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cnazioni.setMinWidth(nuovaLarghezza / cont);   
            
        }

        if(ColMestieri){
            
            
            Cmestieri.setCellValueFactory(new PropertyValueFactory<Tabella, String>("mestieri"));
    
            GG.getColumns().add(Cmestieri);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label10,Campo10);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cmestieri.setMinWidth(nuovaLarghezza / cont);   
            
        }

        if(ColCelebrita == true){
            
            
            Ccelebrita.setCellValueFactory(new PropertyValueFactory<Tabella, String>("celebrita"));
    
            GG.getColumns().add(Ccelebrita);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label11,Campo11);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Ccelebrita.setMinWidth(nuovaLarghezza / cont);   
            
        }
        
        if(ColTot){
           
            TOT.setCellValueFactory(new PropertyValueFactory<Tabella, String>("tot"));
            GG.getColumns().add(TOT);
   
           nuovaLarghezza += 100.0; 
         
           cont += 1;
   
           
           GG.setMinWidth(nuovaLarghezza);
           GG.setPrefWidth(nuovaLarghezza);
           GG.setMaxWidth(Double.MAX_VALUE);
           TOT.setMinWidth(nuovaLarghezza / cont);

       }
    
        addTables();
       
            
    }


       public void updateTimer(ActionEvent event) {
        countdown--;
        TR.setText(String.valueOf(countdown));
    
        if (countdown == 0) {
        
            if(sminchiamento2==false){
                submit(event);
                sminchiamento2=false;
            }
            
            timeline.stop();
            PunteggioTabella();
           
           
           
            clonedTableViews.remove(GG);
    
            countdown = 10;
            sminchiamento = false;
        }

    }


   

    public void PunteggioTabella() {

     int punteggioTotale;
     int punteggioNome;
     int punteggioCosa;
     int punteggioCitta;
     int punteggioFrutta;
     int punteggioVerbi;
     int punteggioAnimali;
     int punteggioPiante;
     int punteggioCantanti;
     int punteggioNazioni;
     int punteggioMestieri;
     int punteggioCelebrita;
     int flagNome;
     int flagCosa;
     int flagCitta;
     int flagFrutta;
     int flagVerbi;
     int flagAnimali;
     int flagPiante;
     int flagCantanti;
     int flagNazioni;
     int flagMestieri;
     int flagCelebrita;
  
    

clonedTableViews.add(0,GG);

  for (int i = 0; i < clonedTableViews.size(); i++) {
     TableView<Tabella> currentTableView = clonedTableViews.get(i);
     ObservableList<Tabella> currentTableData = currentTableView.getItems();
    Tabella lastRow1 = currentTableData.get(currentTableData.size() - 1);


    punteggioNome =0;
    punteggioCosa =0;
    punteggioCitta=0;
    punteggioFrutta=0;
    punteggioVerbi =0;
    punteggioAnimali =0;
    punteggioPiante=0;
    punteggioCantanti=0;
    punteggioNazioni =0;
    punteggioMestieri =0;
    punteggioCelebrita=0;
    flagNome =0;
    flagCosa =0;
    flagCitta=0;
    flagFrutta=0;
    flagVerbi =0;
    flagAnimali =0;
    flagPiante=0;
    flagCantanti=0;
    flagNazioni =0;
    flagMestieri =0;
    flagCelebrita=0;

    System.out.println("TABELLA: " + i);

    
     for (int j = 0; j < clonedTableViews.size() ; j++) {

        if(i!=j){
         
        
         
         TableView<Tabella> nextTableView = clonedTableViews.get(j);
         ObservableList<Tabella> nextTableData = nextTableView.getItems();
         Tabella lastRow2 = nextTableData.get(nextTableData.size() - 1);

         System.out.println("TABELLA: " + i +' '+ j);

        if (ColNome) {
       

        if(lastRow1.getNome().length() > 0 && lastRow2.getNome().length() == 0){

                char primaLetteraInserita1 = lastRow1.getNome().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                     if (punteggioNome != 5 && wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioNome =10;
                        flagNome++;
                        System.out.println("VALORE FLAG NOME: "+flagNome);

                        if(flagNome+1>=clonedTableViews.size())
                        {
                            punteggioNome = 20;
                           
                        }

                     }
                    
        }

        if(lastRow1.getNome().length() > 0 && lastRow2.getNome().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getNome().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getNome().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                
                if (punteggioNome != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getNome().equals(lastRow2.getNome())){
                                  punteggioNome = 5;
                        }
                        else {
                               punteggioNome =10;
                         
                        }	
                }
    

     }

    }
     System.out.println("p 1 " + lastRow1.getNome());
     System.out.println("p 2 " + lastRow2.getNome());
     
    

System.out.println("p nome" + punteggioNome);   

         if (ColCosa) {
            if(lastRow1.getCosa().length() > 0 && lastRow2.getCosa().length() == 0){

                char primaLetteraInserita1 = lastRow1.getCosa().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
                     if (punteggioCosa != 5 && wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioCosa =10;
                        flagCosa++;
                        flagNome++;
                        System.out.println("VALORE FLAG COSA: "+flagCosa);

                        if(flagCosa+1>=clonedTableViews.size())
                        {
                            punteggioCosa = 20;
                           
                        }
                        
                     }
                    
        }

        if(lastRow1.getCosa().length() > 0 && lastRow2.getCosa().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getCosa().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getCosa().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
    
                if (punteggioCosa != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getCosa().equals(lastRow2.getCosa())){
                                  punteggioCosa = 5;
                        }
                        else {
                               punteggioCosa =10;
                         
                        }	
                }

     }
                     
         }
         System.out.println("p 1 " + lastRow1.getCosa());
         System.out.println("p 2 " + lastRow2.getCosa());


System.out.println("p cosa" + punteggioCosa);
         if (ColCitta) {
            if(lastRow1.getCitta().length() > 0 && lastRow2.getCitta().length() == 0){

                char primaLetteraInserita1 = lastRow1.getCitta().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                     if (punteggioCitta != 5 && wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioCitta =10;
                        flagCitta++;
                        System.out.println("VALORE FLAG CITTA: "+flagCitta);

                        if(flagCitta+1>=clonedTableViews.size())
                        {
                            punteggioCitta = 20;
                           
                        }
                        
                     }
                    
        }

        if(lastRow1.getCitta().length() > 0 && lastRow2.getCitta().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getCitta().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getCitta().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                if (punteggioCitta != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getCitta().equals(lastRow2.getCitta())){
                                punteggioCitta = 5;
                        }
                        else {
                               punteggioCitta =10;
                         
                        }	
                }
     }
                     
         }
         System.out.println("p 1 " + lastRow1.getCitta());
         System.out.println("p 2 " + lastRow2.getCitta());


System.out.println("p citta" + punteggioCitta);   

         if (ColFrutta) {
            if(lastRow1.getFrutta().length() > 0 && lastRow2.getFrutta().length() == 0){

                char primaLetteraInserita1 = lastRow1.getFrutta().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                     if (punteggioFrutta != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioFrutta =10;
                        flagFrutta++;
                        System.out.println("VALORE FLAG NOME: "+flagFrutta);

                        if(flagFrutta+1>=clonedTableViews.size())
                        {
                            punteggioFrutta = 20;
                           
                        }
                        
                     }
                    
        }

        if(lastRow1.getFrutta().length() > 0 && lastRow2.getFrutta().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getFrutta().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getFrutta().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                
    
        

                if (punteggioFrutta != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getFrutta().equals(lastRow2.getFrutta())){
                                  punteggioFrutta = 5;
                        }
                        else {
                               punteggioFrutta =10;
                         
                        }	
                }
     }
                     
         }
         System.out.println("p 1 " + lastRow1.getFrutta());
         System.out.println("p 2 " + lastRow2.getFrutta());

System.out.println("p Frutta" + punteggioFrutta);   

if (ColVerbi) {

    if(lastRow1.getVerbi().length() > 0 && lastRow2.getVerbi().length() == 0){

            char primaLetteraInserita1 = lastRow1.getVerbi().charAt(0);
           
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getVerbi(), "verbi.txt");
                 if (punteggioVerbi != 5 && wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                 {
                    punteggioVerbi =10;
                    flagVerbi++;
                        System.out.println("VALORE FLAG VERBI: "+flagVerbi);

                        if(flagVerbi+1>=clonedTableViews.size())
                        {
                            punteggioVerbi = 20;
                           
                        }
                    

                 }
                
    }

    if(lastRow1.getVerbi().length() > 0 && lastRow2.getVerbi().length() > 0 ){

             char primaLetteraInserita1 = lastRow1.getVerbi().charAt(0);
             char primaLetteraInserita2 = lastRow2.getVerbi().charAt(0);
             SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
             boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getVerbi(), "verbi.txt");
             boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getVerbi(), "verbi.txt");
            
            if (punteggioVerbi != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                    if(lastRow1.getVerbi().equals(lastRow2.getVerbi())){
                              punteggioVerbi = 5;
                    }
                    else {
                           punteggioVerbi =10;
                     
                    }	
            }


 }

}
 System.out.println("p 1 " + lastRow1.getVerbi());
 System.out.println("p 2 " + lastRow2.getVerbi());
 


System.out.println("p verbi" + punteggioVerbi);   

if (ColAnimali) {

    if(lastRow1.getAnimali().length() > 0 && lastRow2.getAnimali().length() == 0){

            char primaLetteraInserita1 = lastRow1.getAnimali().charAt(0);
           
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getAnimali(), "animali.txt");
                 if (punteggioAnimali != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                 {
                    punteggioAnimali =10;
                    flagAnimali++;
                        System.out.println("VALORE FLAG ANIMALI: "+flagAnimali);

                        if(flagAnimali+1>=clonedTableViews.size())
                        {
                            punteggioAnimali = 20;
                           
                        }
                 }
                
    }

    if(lastRow1.getAnimali().length() > 0 && lastRow2.getAnimali().length() > 0 ){

             char primaLetteraInserita1 = lastRow1.getAnimali().charAt(0);
             char primaLetteraInserita2 = lastRow2.getAnimali().charAt(0);
             SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
             boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getAnimali(), "animali.txt");
             boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getAnimali(), "animali.txt");
            
            if (punteggioAnimali != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                    if(lastRow1.getAnimali().equals(lastRow2.getAnimali())){
                              punteggioAnimali = 5;
                    }
                    else {
                           punteggioAnimali =10;
                     
                    }	
            }


 }

}
 System.out.println("p 1 " + lastRow1.getAnimali());
 System.out.println("p 2 " + lastRow2.getAnimali());
 


System.out.println("p animali" + punteggioAnimali);   
if (ColPiante) {

    if(lastRow1.getPiante().length() > 0 && lastRow2.getPiante().length() == 0){

            char primaLetteraInserita1 = lastRow1.getPiante().charAt(0);
           
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getPiante(), "piante.txt");
                 if (punteggioPiante != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                 {
                    punteggioPiante =10;
                    flagPiante++;
                        System.out.println("VALORE FLAG PIANTE: "+flagPiante);

                        if(flagPiante+1>=clonedTableViews.size())
                        {
                            punteggioPiante = 20;
                           
                        }
                  

                 }
                
    }

    if(lastRow1.getPiante().length() > 0 && lastRow2.getPiante().length() > 0 ){

             char primaLetteraInserita1 = lastRow1.getPiante().charAt(0);
             char primaLetteraInserita2 = lastRow2.getPiante().charAt(0);
             SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
             boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getPiante(), "piante.txt");
             boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getPiante(), "piante.txt");
            
            if (punteggioPiante != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                    if(lastRow1.getPiante().equals(lastRow2.getPiante())){
                              punteggioPiante = 5;
                    }
                    else {
                           punteggioPiante =10;
                     
                    }	
            }


 }

}
 System.out.println("p 1 " + lastRow1.getPiante());
 System.out.println("p 2 " + lastRow2.getPiante());
 


System.out.println("p piante" + punteggioPiante);   
if (ColCantanti) {

    if(lastRow1.getCantanti().length() > 0 && lastRow2.getCantanti().length() == 0){

            char primaLetteraInserita1 = lastRow1.getCantanti().charAt(0);
           
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCantanti(), "cantanti.txt");
                 if (punteggioCantanti != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                 {
                    punteggioCantanti =10;
                    flagCantanti++;
                        System.out.println("VALORE FLAG CANTANTI: "+flagCantanti);

                        if(flagCantanti+1>=clonedTableViews.size())
                        {
                            punteggioCantanti = 20;
                           
                        }
                    

                 }
                
    }

    if(lastRow1.getCantanti().length() > 0 && lastRow2.getCantanti().length() > 0 ){

             char primaLetteraInserita1 = lastRow1.getCantanti().charAt(0);
             char primaLetteraInserita2 = lastRow2.getCantanti().charAt(0);
             SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
             boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getCantanti(), "cantanti.txt");
             boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getCantanti(), "cantanti.txt");
            
            if (punteggioCantanti != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                    if(lastRow1.getCantanti().equals(lastRow2.getCantanti())){
                              punteggioCantanti = 5;
                    }
                    else {
                           punteggioCantanti =10;
                     
                    }	
            }


 }

}
 System.out.println("p 1 " + lastRow1.getCantanti());
 System.out.println("p 2 " + lastRow2.getCantanti());
 


System.out.println("p cantanti" + punteggioCantanti);  
if (ColNazioni) {

    if(lastRow1.getNazioni().length() > 0 && lastRow2.getNazioni().length() == 0){

            char primaLetteraInserita1 = lastRow1.getNazioni().charAt(0);
           
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getNazioni(), "nazioni.txt");
                 if (punteggioNazioni != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                 {
                    punteggioNazioni =10;
                    flagNazioni++;
                        System.out.println("VALORE FLAG NAZIONI: "+flagNazioni);

                        if(flagNazioni+1>=clonedTableViews.size())
                        {
                            punteggioNazioni = 20;
                           
                        }
             

                 }
                
    }

    if(lastRow1.getNazioni().length() > 0 && lastRow2.getNazioni().length() > 0 ){

             char primaLetteraInserita1 = lastRow1.getNazioni().charAt(0);
             char primaLetteraInserita2 = lastRow2.getNazioni().charAt(0);
             SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
             boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getNazioni(), "nazioni.txt");
             boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getNazioni(), "nazioni.txt");
            
            if (punteggioNazioni != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                    if(lastRow1.getNazioni().equals(lastRow2.getNazioni())){
                              punteggioNazioni = 5;
                    }
                    else {
                           punteggioNazioni =10;
                     
                    }	
            }


 }

}
 System.out.println("p 1 " + lastRow1.getNazioni());
 System.out.println("p 2 " + lastRow2.getNazioni());

System.out.println("p nazioni" + punteggioNazioni);   
 if (ColMestieri) {

        if(lastRow1.getMestieri().length() > 0 && lastRow2.getMestieri().length() == 0){

                char primaLetteraInserita1 = lastRow1.getMestieri().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getMestieri(), "mestieri.txt");
                     if (punteggioMestieri != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioMestieri =10;
                        flagMestieri++;
                        System.out.println("VALORE FLAG MESTIERI: "+flagMestieri);

                        if(flagMestieri+1>=clonedTableViews.size())
                        {
                            punteggioMestieri = 20;
                           
                        }
                      

                     }
                    
        }

        if(lastRow1.getMestieri().length() > 0 && lastRow2.getMestieri().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getMestieri().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getMestieri().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getMestieri(), "mestieri.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getMestieri(), "mestieri.txt");
                
                if (punteggioMestieri != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getMestieri().equals(lastRow2.getMestieri())){
                                  punteggioMestieri = 5;
                        }
                        else {
                               punteggioMestieri =10;
                         
                        }	
                }
    

     }

    }
     System.out.println("p 1 " + lastRow1.getMestieri());
     System.out.println("p 2 " + lastRow2.getMestieri());
     
    

System.out.println("p MESTIERI" + punteggioMestieri);   
if (ColCelebrita) {

    if(lastRow1.getCelebrita().length() > 0 && lastRow2.getCelebrita().length() == 0){

            char primaLetteraInserita1 = lastRow1.getCelebrita().charAt(0);
           
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCelebrita(), "celebrita.txt");
                 if (punteggioCelebrita != 5 &&wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                 {
                    punteggioCelebrita =10;
                    flagCelebrita++;
                        System.out.println("VALORE FLAG CELEBRITA: "+flagCelebrita);

                        if(flagCelebrita+1>=clonedTableViews.size())
                        {
                            punteggioCelebrita = 20;
                           
                        }

                 }
                
    }

    if(lastRow1.getCelebrita().length() > 0 && lastRow2.getCelebrita().length() > 0 ){

             char primaLetteraInserita1 = lastRow1.getCelebrita().charAt(0);
             char primaLetteraInserita2 = lastRow2.getCelebrita().charAt(0);
             SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
             boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getCelebrita(), "celebrita.txt");
             boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getCelebrita(), "celebrita.txt");
            
            if (punteggioCelebrita != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                    if(lastRow1.getCelebrita().equals(lastRow2.getCelebrita())){
                              punteggioCelebrita = 5;
                    }
                    else {
                           punteggioCelebrita =10;
                     
                    }	
            }


 }

}
 System.out.println("p 1 " + lastRow1.getCelebrita());
 System.out.println("p 2 " + lastRow2.getCelebrita());
 


System.out.println("p celebrita" + punteggioCelebrita);   



        }

        
       
                
 }

           

             punteggioTotale = 0; 

             punteggioTotale += (punteggioNome + punteggioCosa + punteggioCitta + punteggioFrutta + punteggioVerbi + punteggioAnimali + punteggioPiante + punteggioCantanti + punteggioNazioni + punteggioMestieri + punteggioCelebrita);
             System.out.println("Punteggio TOT  " + punteggioTotale);  
    
     
       lastRow1.setTot(punteggioTotale); 

       
        arrayPunteggi[i] += punteggioTotale;
        System.out.println("Punteggio Partita " + arrayPunteggi[i]);  
      
   
       currentTableView.refresh();  

   // TableView<Tabella> tabTemp = clonedTableViews.remove(0);
   // clonedTableViews.add(tabTemp);
    
            }  
}
    public void addTables()
    {
         double nuovaLarghezza = 0.0;
         int numCol = 0;

            if (ColNome){
                numCol++;
            }
            if (ColCosa){
                numCol++;
            }
            if (ColCitta){
                numCol++;
            }
            if (ColFrutta){
                numCol++;
            }
            if (ColVerbi){
                numCol++;
            }
            if (ColAnimali){
                numCol++;
            }
            if (ColPiante){
                numCol++;
            }
            if (ColCantanti){
                numCol++;
            }
             if (ColNazioni){
                numCol++;
            }
            if (ColMestieri){
                numCol++;
            }
            if (ColCelebrita){
                numCol++;
            }
             if (ColTot){
                numCol++;
            }
            
            nuovaLarghezza += (numCol*100.0); 

            for(int i =0; i<numTab;i++){
           

            CustomTables tableViewCloner = new CustomTables();
            TableView<Tabella> clonedTableView = tableViewCloner.cloneTableViewStructure(GG);
            clonedTableViews.add(clonedTableView);
            v1.getChildren().addAll(clonedTableView);
            v1.setMinWidth(nuovaLarghezza);
            v1.setPrefWidth(nuovaLarghezza);
            v1.setMaxWidth(Double.MAX_VALUE);
           
            }

    }



public void randomChar(ActionEvent event) {

    numPartite +=1;
    if(numPartite<20){
    String alfabetoItaliano = "abcdefgilmnopqrstuvz";
    Random random = new Random();
    char randomLetter = alfabetoItaliano.charAt(random.nextInt(alfabetoItaliano.length()));
    this.LetteraCasuale = randomLetter;

    Lettera.setText(String.valueOf(randomLetter));
    RL.setVisible(false);
    RandomCharButton = false; 

    for (TableView<Tabella> tableView : clonedTableViews) {
        ObservableList<Tabella> items = tableView.getItems();
        for (Tabella row : items) {
            row.setNome("");
            row.setCosa("");
            row.setCitta("");
            row.setFrutta("");
            row.setVerbi("");
            row.setAnimali("");
            row.setPiante("");
            row.setCantanti("");
            row.setNazioni("");
            row.setMestieri("");
            row.setCelebrita("");
            row.setTot(0);
        }
        tableView.refresh();
    }

        
        startThreads(LetteraCasuale);
        running = true;
   
    
    
    }
    else{
        terminaPartita(event);
    }
}

public void back(ActionEvent event){

       
    Scene2View scene = new Scene2View(model);
    scene.showView();

    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    currentStage.close();
    
}


    public void submit(ActionEvent event) {
        sminchiamento2 = true;

        stopThreads();
         

        ObservableList<Tabella> TT = GG.getItems();
      
        BuilderTabella builder = new BuilderTabella();
        
 
        if (ColNome) {
             builder.setNome(Campo1.getText());
             Campo1.setText("");

    }
    

        if (ColCosa) {
             builder.setCosa(Campo2.getText());
             Campo2.setText("");
            
    }
    
    if (ColCitta) {
             builder.setCitta(Campo3.getText());
             Campo3.setText("");
           
    }
    
    if (ColFrutta) {
             builder.setFrutta(Campo4.getText());
             Campo4.setText("");
           
    }

    
    if (ColVerbi) {
        builder.setVerbi(Campo5.getText());
        Campo5.setText("");

}


   if (ColAnimali) {
        builder.setAnimali(Campo6.getText());
        Campo6.setText("");
       
}

if (ColPiante) {
        builder.setPiante(Campo7.getText());
        Campo7.setText("");
      
}

if (ColCantanti) {
        builder.setCantanti(Campo8.getText());
        Campo8.setText("");
      
}

if (ColNazioni) {
    builder.setNazioni(Campo9.getText());
    Campo9.setText("");

}


if (ColMestieri) {
    builder.setMestieri(Campo10.getText());
    Campo10.setText("");
   
}

if (ColCelebrita) {
    builder.setCelebrita(Campo11.getText());
    Campo11.setText("");
  
}
 if(sminchiamento==false)
 {
    timeline.play();
    sminchiamento = true;
    TR.setVisible(true);
 }
    


        Tabella row = builder.build();
        TT.add(row);

        GG.setItems(TT); 


        GG.refresh();

        if(!RandomCharButton){
             RL.setVisible(true);
        }
        
    }


    public void startThreads(char L) {


        for (TableView<Tabella> tableView : clonedTableViews) {
            int numberOfColumns = tableView.getColumns().size();
            AtomicInteger numparole = new AtomicInteger(0);
           
            Thread tableThread = new Thread(() -> {
                
                    try {
                        for (TableColumn<Tabella, ?> column : tableView.getColumns()) {
                            
                            if(running){

                            int randomDelay = new Random().nextInt(20) + 2;
                            Thread.sleep(randomDelay * 1000);
    

                            String columnHeaderText = column.getText();
                            if ("tot".equalsIgnoreCase(columnHeaderText)) {
                                continue;
                            }

                            if(searchAndAddData(tableView, columnHeaderText, L))
                            {
                                numparole.incrementAndGet();
                            }

                            if (numparole.get() + 1 == numberOfColumns && sminchiamento == false) {
                                System.out.println("thread: " + tableView +" Paerole inserite: " + numparole.get() + " Numero colonne: " + numberOfColumns);
                                                            
                                stopThreads();
                                sminchiamento = true;
                                TR.setVisible(true);
                                timeline.play();
 
                            } 
                        }
                        }
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                
            });
            tableThread.setDaemon(true);
            tableThread.start();
        }

    }


    private boolean searchAndAddData(TableView<Tabella> tableView, String columnHeaderText, char L) {
        SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
        String word = sequentialSearch.search(L, columnHeaderText.toLowerCase() + ".txt");
        System.out.println("Word found for '" + columnHeaderText + "' column: " + word);
        boolean wordfinded;

        if (!word.isEmpty()) {
            
            Platform.runLater(() -> {
                ObservableList<Tabella> TT = tableView.getItems();
                BuilderTabella builder = new BuilderTabella();
                Tabella currentRow;
                if (TT.isEmpty()) {
                    currentRow = builder
                            .setNome("")
                            .setCosa("")
                            .setCitta("")
                            .setFrutta("")
                            .setVerbi("")
                            .setAnimali("")
                            .setPiante("")
                            .setCantanti("")
                            .setNazioni("")
                            .setMestieri("")
                            .setCelebrita("")
                            .build();
                    TT.add(currentRow);
                    
                } else {
                    currentRow = TT.get(0);
                   
                }

                
                switch (columnHeaderText.toLowerCase()) {
                    case "nome":
                        currentRow.setNome(word);
                        break;
                    case "cosa":
                        currentRow.setCosa(word);
                        break;
                    case "citta":
                        currentRow.setCitta(word);
                        break;
                    case "frutta":
                        currentRow.setFrutta(word);
                        break;
                    case "verbi":
                        currentRow.setVerbi(word);
                        break;
                    case "animali":
                        currentRow.setAnimali(word);
                        break;
                    case "piante":
                        currentRow.setPiante(word);
                        break;
                    case "cantanti":
                        currentRow.setCantanti(word);
                        break;
                    case "nazioni":
                        currentRow.setNazioni(word);
                        break;
                    case "mestieri":
                        currentRow.setMestieri(word);
                        break;
                    case "celebrita":
                        currentRow.setCelebrita(word);
                        break;
                    default:
                        break;
                }

                tableView.refresh();
            });

           wordfinded = true;
        }else{
            wordfinded = false;
            ObservableList<Tabella> TT = tableView.getItems();
            BuilderTabella builder = new BuilderTabella();
            Tabella currentRow;
            if (TT.isEmpty()) {
                currentRow = builder
                        .setNome("")
                        .setCosa("")
                        .setCitta("")
                        .setFrutta("")
                        .setVerbi("")
                        .setAnimali("")
                        .setPiante("")
                        .setCantanti("")
                        .setNazioni("")
                        .setMestieri("")
                        .setCelebrita("")
                        .build();
                TT.add(currentRow);
                
            } else {
                currentRow = TT.get(0);
               
            }
        }

        return wordfinded;
    }

    public void stopThreads() {
        running = false;
    }


   
       

    public void terminaPartita(ActionEvent event){

        int max;
        int maxIndex;
        int[] B = new int[numTab+1];
        int[] C = new int[numTab+1];

        for(int i= 0; i < arrayPunteggi.length; i++){
             max = Integer.MIN_VALUE; 
             maxIndex = -1;
            for(int j = 0; j < arrayPunteggi.length; j++){
                if(max<=arrayPunteggi[j]){
                    max = arrayPunteggi[j];
                    maxIndex = j;
                }
            }

            B[i] = max;
            C[i] = maxIndex;
            arrayPunteggi[maxIndex] = Integer.MIN_VALUE;

            System.out.println("B[" + i + "]: " + B[i]);
            System.out.println("C[" + i + "]: " + C[i]);
        }

        model.setPunteggi(B);
        model.setPosizioni(C);

    
        FinalScene View = new FinalScene(model);
        View.showView();

      
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

}