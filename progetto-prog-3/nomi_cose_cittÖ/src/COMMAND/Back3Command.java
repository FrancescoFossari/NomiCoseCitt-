package COMMAND;

import MVC.FinalSceneController;

import javafx.event.ActionEvent;

public class Back3Command implements Command{
     private FinalSceneController controller;
    private ActionEvent event;

    public Back3Command(FinalSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.back(event);
    }
    
}
