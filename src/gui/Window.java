package gui;

import controllers.GameController;
import controllers.HelpController;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author anikristo
 */
public class Window extends JFrame implements WindowListener, Observer {

    // ATTRIBUTES
    private HomeScreen homeScreen;
    private PlayerRegistrationScreen playRegScreen;
    private GameScreen gameScreen;
    private HighScoresScreen highScoresScreen;
    private HelpScreen helpScreen;

    private GameController gameController;
    private HelpController helpController;

    // CONSTRUCTOR
    public Window() {
        super("µMonopoly");

        helpController = new HelpController();
        gameController = new GameController(helpController);

        setSize(1152, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Instantiating the panels
        homeScreen = new HomeScreen();
        playRegScreen = new PlayerRegistrationScreen(gameController);
        gameScreen = gameController.getGame().getView();
        highScoresScreen = new HighScoresScreen();
        helpScreen = new HelpScreen(helpController.getHelp());

        homeScreen.addObserver(this);
        playRegScreen.addObserver(this);
        gameScreen.addObserver(this); // TODO board and sidepanel should actually be observable
        highScoresScreen.addObserver(this);

        setContentPane(homeScreen.getContent());
        setVisible(true);
    }


    // METHODS
    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable == homeScreen) {
            if (o == NotificationMsg.PLAY_REG) {
                setContentPane(playRegScreen.getContent());
            } else if (o == NotificationMsg.HIGH_SCORES) {
                setContentPane(highScoresScreen.getContent());
            } else if (o == NotificationMsg.HELP) {
                setContentPane(helpScreen.getContent());
            } else if (o == NotificationMsg.QUIT) {
                System.exit(0);
            }
        } else if (observable == highScoresScreen) {
            // TODO
        } else if (observable == helpScreen) {
            // TODO
        } else if (observable == playRegScreen) {
            // TODO
            if (o == NotificationMsg.BACK) {
                setContentPane(homeScreen.getContent());
            }
        } else if (observable == gameScreen) {
            // TODO
        }
        repaint();
        revalidate();
    }


    /**
     * This is an enumeration for the intent intermediation
     */
    enum NotificationMsg {
        PLAY_REG, HIGH_SCORES, HELP, QUIT, NEW_GAME, BACK
    }
}
