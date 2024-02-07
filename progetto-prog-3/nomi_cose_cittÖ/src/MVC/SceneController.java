package MVC;

import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneController {
    
    private model1 model;

    public SceneController(model1 model) {
        this.model = model;
    }

    
    public void handleLoginAction(ActionEvent event) {


        if (!model.getUsername().isEmpty() && !model.getPassword().isEmpty()) {
            SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
            boolean wordExists1 = sequentialSearch.searchWord(model.getUsername(),"credenziali.txt");
            boolean wordExists2 = sequentialSearch.searchWord(model.getPassword(), "credenziali.txt");
            if(wordExists1 && wordExists2){
                
                Scene2View scene2View = new Scene2View(model);
                scene2View.showView();
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();

     }
    }
    }

    
    public void handleSignUpAction(ActionEvent event){
        
        Scene3View scene3View = new Scene3View(model);
        scene3View.showView1();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
       
    }

}