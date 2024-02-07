package COMMAND;

import MVC.MainSceneController;
import javafx.event.ActionEvent;

public class SubmitCommand implements Command{
    private MainSceneController controller;
    private ActionEvent event;

    public SubmitCommand(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.submit(event);
    }
    
}
