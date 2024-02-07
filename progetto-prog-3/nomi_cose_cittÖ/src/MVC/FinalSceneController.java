package MVC;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FinalSceneController {

    private model1 model;


    public FinalSceneController(model1 model)
    {
        this.model = model;
    }


    public void back(ActionEvent event){

       
        Scene2View scene = new Scene2View(model);
        scene.showView();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
    }
   
    
}









