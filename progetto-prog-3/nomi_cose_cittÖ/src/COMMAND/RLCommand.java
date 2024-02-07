package COMMAND;

import MVC.MainSceneController;
import javafx.event.ActionEvent;

public class RLCommand implements Command {

     private MainSceneController controller;
    private ActionEvent event;

    public RLCommand(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.randomChar(event);
    }
    
}
