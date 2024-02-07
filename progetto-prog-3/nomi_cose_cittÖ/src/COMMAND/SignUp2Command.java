package COMMAND;

import MVC.Scene3controller;

import javafx.event.ActionEvent;

public class SignUp2Command implements Command {

    private Scene3controller controller;
    private ActionEvent event;

     public SignUp2Command(Scene3controller controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.signup(event);
    }
}
