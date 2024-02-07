package COMMAND;


import MVC.Scene2Controller;
import javafx.event.ActionEvent;

public class BackCommand implements Command{

    private Scene2Controller controller;
    private ActionEvent event;

    public BackCommand(Scene2Controller controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.back(event);
    }
    
}
