package MVC.View;

import MVC.Controller.MainController;
import MVC.Model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainView extends JFrame implements ActionListener {

    private MainModel model;
    private JButton okButton;
    private JTextField nameField;
    private JPasswordField passField;

    private LoginListener loginListener;

    public MainView(MainModel model) {
        super("MVC Demo");

        this.model = model;

        nameField = new JTextField(10);
        passField = new JPasswordField(10);
        okButton = new JButton("OK");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.gridx=1;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(100, 0, 0, 10);
        gc.fill=GridBagConstraints.NONE;

        add(new JLabel("Name: "), gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx=2;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(100, 0, 0, 0);
        gc.fill=GridBagConstraints.NONE;

        add(nameField, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx=1;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.fill=GridBagConstraints.NONE;

        add(new JLabel("Password: "), gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx=2;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill=GridBagConstraints.NONE;

        add(passField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx=2;
        gc.gridy=3;
        gc.weightx=1;
        gc.weighty=100;
        gc.fill=GridBagConstraints.NONE;

        add(okButton, gc);

        okButton.addActionListener(this);

        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String password = new String(passField.getPassword());
        String name = nameField.getText();

        fireLoginEvent(new LoginFormEvent(name, password));
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void fireLoginEvent(LoginFormEvent event) {
        if(loginListener != null) {
            loginListener.loginPerformed(event);
        }
    }

}


/*public class MainView extends JFrame implements ActionListener{

    private MainModel mainModel;

    private JButton helloButton;
    private JButton goodByeButton;

    public MainView(MainModel mainModel){
        super("MVCDemo");
        this.mainModel =mainModel;


        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        helloButton = new JButton("Click me!");
        goodByeButton = new JButton("Good bye!");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridheight = 0;
        gc.gridwidth = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        add(helloButton);
        add(goodByeButton);

        helloButton.addActionListener(this::actionPerformed2);
        helloButton.addActionListener(e->actionPerformed(e));
        helloButton.addActionListener(this);
        goodByeButton.addActionListener(this);

        goodByeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sorry to see you go!");
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton source = (JButton) e.getSource();

        if(source == helloButton)
            System.out.println("Hello World!");
        else
            System.out.println("Other Button!");

    }

    public void actionPerformed2(ActionEvent e) {
        System.out.println("Hello World!");
    }
}*/
