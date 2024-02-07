package MVC;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AppController {
    private model1 model;

    public AppController(model1 model) {
        this.model = model;
    }

     public void Next(ActionEvent event){
        
        Scene1View scene1View = new Scene1View(model);
        scene1View.showView();

      
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
       
    }
}
