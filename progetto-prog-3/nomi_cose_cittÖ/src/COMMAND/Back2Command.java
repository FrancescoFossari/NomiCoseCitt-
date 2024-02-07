package COMMAND;

import MVC.MainSceneController;
import javafx.event.ActionEvent;

public class Back2Command  implements Command{
    private MainSceneController controller;
    private ActionEvent event;

    public Back2Command(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.back(event);
    }
    
}
