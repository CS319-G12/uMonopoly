package gui;

import controllers.GameController;
import controllers.HelpController;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ani Kristo
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

        homeScreen = new HomeScreen();
        homeScreen.addObserver(this);

        setContentPane(homeScreen.getContent());
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    // METHODS
    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        // TODO check if game has finished
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
                if (playRegScreen == null) {
                    playRegScreen = new PlayerRegistrationScreen(gameController);
                    playRegScreen.addObserver(this);
                }
                setContentPane(playRegScreen.getContent());
            } else if (o == NotificationMsg.HIGH_SCORES) {
                if (highScoresScreen == null) {
                    highScoresScreen = new HighScoresScreen();
                    highScoresScreen.addObserver(this);
                }
                setContentPane(highScoresScreen.getContent());
            } else if (o == NotificationMsg.HELP) {
                if (helpScreen == null) {
                    helpScreen = new HelpScreen(helpController.getHelp());
                }
                setContentPane(helpScreen.getContent());
            } else if (o == NotificationMsg.QUIT) {
                System.exit(0);
            }
        } else if (observable == highScoresScreen) {
            // TODO
        } else if (observable == helpScreen) {
            // TODO
        } else if (observable == playRegScreen) {
            if (o == NotificationMsg.BACK) {
                setContentPane(homeScreen.getContent());
            } else if (o == NotificationMsg.NEW_GAME) {
                if (gameScreen == null) {
                    gameScreen = gameController.getGame().getView();
                    gameScreen.addObserver(this); // TODO board and side panel should actually be observable
                }

                JScrollPane scrollPane = new JScrollPane(gameScreen.getContent());
                setContentPane(scrollPane);
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
