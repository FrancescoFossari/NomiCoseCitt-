package COMMAND;
import MVC.MainSceneController;
import javafx.event.ActionEvent;


public class StartCommand implements Command{

    private MainSceneController controller;
    private ActionEvent event;

    public StartCommand(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    @Override
    public void execute() {
        controller.startGame(event);
    }
    
}
