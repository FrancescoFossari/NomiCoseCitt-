package COMMAND;

import MVC.MainSceneController;
import javafx.event.ActionEvent;

public class TerminaCommand implements Command{
    private MainSceneController controller;
    private ActionEvent event;

    public TerminaCommand(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.terminaPartita(event);
    }
    
    
}
