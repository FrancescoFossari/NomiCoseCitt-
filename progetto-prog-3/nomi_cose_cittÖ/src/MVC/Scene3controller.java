package MVC;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;


public class Scene3controller {
    
    private String username;
    private String password;
    private String mail;
    private model1 model;
   

    public Scene3controller(model1 model) {
       this.model = model;
    }

    public void back(ActionEvent event){

       
        Scene1View scene = new Scene1View(model);
        scene.showView();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
    }
    

    
    public void signup(ActionEvent event) {
        username = model.getUsername();
        password = model.getPassword();
        mail = model.getMail();

        if (!username.isEmpty() && !password.isEmpty() && !mail.isEmpty()) {

            writeToFile("nomi_cose_città/src/dizionario/credenziali.txt");
            Scene2View scene2View = new Scene2View(model);
            scene2View.showView();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
 
        }
    }
    
    private void writeToFile(String filePath) {
        try {

            // Verifica se il file esiste già, in caso contrario crea un nuovo file
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Usa BufferedWriter in modalità di append per aggiungere i dati al file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
               
                writer.newLine();
                writer.newLine();
                writer.write(username);
                writer.newLine();
                writer.write(password);
                writer.newLine();
                writer.write(mail);
                writer.newLine();
                
                System.out.println("Dati aggiunti a " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}