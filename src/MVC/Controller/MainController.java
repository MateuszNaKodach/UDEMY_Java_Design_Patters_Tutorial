package MVC.Controller;

import MVC.Model.MainModel;
import MVC.View.LoginFormEvent;
import MVC.View.LoginListener;
import MVC.View.MainView;

/**
 * Created by Mateusz on 23.12.2016.
 */
public class MainController implements LoginListener{

    private MainModel mainModel;
    private MainView mainView;

    public MainController(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void loginPerformed(LoginFormEvent event) {
        System.out.println("Login event received, name: "+ event.getName() + "Password: " +event.getPassword());
    }
}
