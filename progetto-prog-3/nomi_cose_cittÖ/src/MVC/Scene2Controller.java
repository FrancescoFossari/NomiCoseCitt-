package MVC;



import javafx.event.ActionEvent;

import javafx.scene.Node;
import javafx.stage.Stage;



public class Scene2Controller {

    private model1 model;
    private boolean nome;
    private boolean cose;
    private boolean citta;
    private boolean frutta;
    private boolean verbi;
    private boolean animali;
    private boolean piante;
    private boolean cantanti;
    private boolean nazioni;
    private boolean mestieri;
    private boolean celebrita;
    
    
    private int numPlayers;
 
    public Scene2Controller(model1 model){
        this.model = model;
    }

    public void setCat1(ActionEvent event) {
        this.nome = !this.nome;
        System.out.println("Valore di nome: " + this.nome);
    }

    
    public void setCat2(ActionEvent event) {
        this.cose = !this.cose;
        System.out.println("Valore di cosa: " + this.cose);
    }

    
    public void setCat3(ActionEvent event) {
        this.citta = !this.citta;
        System.out.println("Valore di citta: " + this.citta);
    }

    
    public void setCat4(ActionEvent event) {
        this.frutta = !this.frutta;
        System.out.println("Valore di frutta: " + this.frutta);
    }


    
    public void setCat5(ActionEvent event) {
        this.verbi = !this.verbi;
        System.out.println("Valore di verbi: " + this.verbi);
    }

    
    public void setCat6(ActionEvent event) {
        this.animali = !this.animali;
        System.out.println("Valore di animali: " + this.animali);
    }

    
    public void setCat7(ActionEvent event) {
        this.piante = !this.piante;
        System.out.println("Valore di piante: " + this.piante);
    }

    
    public void setCat8(ActionEvent event) {
        this.cantanti = !this.cantanti;
        System.out.println("Valore di cantanti: " + this.cantanti);
    }


    public void setCat9(ActionEvent event) {
        this.nazioni = !this.nazioni;
        System.out.println("Valore di nazioni: " + this.nazioni);
    }

    
    public void setCat10(ActionEvent event) {
        this.mestieri = !this.mestieri;
        System.out.println("Valore di mestieri: " + this.mestieri);
    }

    
    public void setCat11(ActionEvent event) {
        this.celebrita = !this.celebrita;
        System.out.println("Valore di celebrita: " + this.celebrita);
    }

    

    public boolean getNome() {
        return this.nome;
    }

    public boolean getCose() {
        return this.cose;
    }

    public boolean getCitta() {
        return this.citta;
    }

    public boolean getFrutta() {
        return this.frutta;
    }

    public boolean getVerbi() {
        return this.verbi;
    }

    public boolean getAnimali() {
        return this.animali;
    }

    public boolean getPiante() {
        return this.piante;
    }

    public boolean getCantanti() {
        return this.cantanti;
    }

    public boolean getNazioni() {
        return this.nazioni;
    }

    public boolean getMestieri() {
        return this.mestieri;
    }

    public boolean getCelebrita() {
        return this.celebrita;
    }

  


    public void back(ActionEvent event){

       
        Scene1View scene = new Scene1View(model);
        scene.showView();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
    }



    
    public void playGame(int numPLayers, ActionEvent event) {

        this.numPlayers = numPLayers;
        
       
        model.setCat1(nome);
        model.setCat2(cose);
        model.setCat3(citta);
        model.setCat4(frutta);
        model.setCat5(verbi);
        model.setCat6(animali);
        model.setCat7(piante);
        model.setCat8(cantanti);
        model.setCat9(nazioni);
        model.setCat10(mestieri);
        model.setCat11(celebrita);
        model.setNumPlayers(numPlayers);
      
        MainScene Scena = new MainScene(model);
        Scena.showView();

         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }
}
