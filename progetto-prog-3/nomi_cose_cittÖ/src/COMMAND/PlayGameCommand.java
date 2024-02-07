package COMMAND;

import javafx.event.ActionEvent;
import MVC.Scene2Controller;

public class PlayGameCommand implements Command {

    private Scene2Controller controller;
    private int numPlayers;
    private ActionEvent event;

    public PlayGameCommand(Scene2Controller controller, int numPlayers, ActionEvent event) {
        this.controller = controller;
        this.numPlayers = numPlayers;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.playGame(numPlayers, event);
    }
}