package COMMAND;

import MVC.SceneController;
import javafx.event.ActionEvent;

public class LoginCommand implements Command {
    private SceneController controller;
    private ActionEvent event; // Aggiungi un campo per l'ActionEvent

    public LoginCommand(SceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.handleLoginAction(event);
    }
}