package COMMAND;

import MVC.SceneController;
import javafx.event.ActionEvent;

public class SignUpCommand implements Command {
    private SceneController controller;
    private ActionEvent event; // Aggiungi un campo per l'ActionEvent

    public SignUpCommand(SceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.handleSignUpAction(event);
    }
}