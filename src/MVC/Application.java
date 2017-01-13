package MVC;

import MVC.Controller.MainController;
import MVC.Model.MainModel;
import MVC.View.MainView;

import javax.swing.*;

/**
 * Created by Mateusz on 23.12.2016.
 */
public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runApp();
            }
        });
    }

    public static void runApp() {
        MainModel mainModel = new MainModel();
        MainView mainView = new MainView(mainModel);
        //Controller observes view, which is a subject in this pattern
        MainController mainController = new MainController(mainModel, mainView);
        mainView.setLoginListener(mainController);
    }
}
