package gui;

import controllers.GameController;
import controllers.HelpController;
import controllers.dbmanagement.HighScoreController;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ani Kristo
 */
public class Window extends JFrame implements Observer {

    // ATTRIBUTES
    private HomeScreen homeScreen;
    private PlayerRegistrationScreen playRegScreen;
    private GameScreen gameScreen;
    private HighScoresScreen highScoresScreen;
    private HelpScreen helpScreen;

    private GameController gameController;
    private HelpController helpController;
    private HighScoreController hsController;

    private boolean gameFinished;

    // CONSTRUCTOR
    public Window() {
        super("µMonopoly");

        helpController = new HelpController();
        gameController = new GameController(helpController);
        hsController = new HighScoreController();

        setSize(1185, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homeScreen = new HomeScreen();
        homeScreen.addObserver(this);

        gameFinished = false;

        setContentPane(homeScreen.getContent());
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    // METHODS
    @Override
    public void update(Observable observable, Object o) {
        if (observable == homeScreen) {
            if (o == NotificationMsg.PLAY_REG) {
                if (gameFinished) {
                    gameController = new GameController(helpController);
                    playRegScreen = new PlayerRegistrationScreen(gameController);
                    playRegScreen.addObserver(this);
                }

                if (playRegScreen == null) {
                    playRegScreen = new PlayerRegistrationScreen(gameController);
                    playRegScreen.addObserver(this);
                }
                setContentPane(playRegScreen.getContent());
            } else if (o == NotificationMsg.HIGH_SCORES) {
                if (highScoresScreen == null || hsController.hasChanged()) {
                    highScoresScreen = new HighScoresScreen(hsController);
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
            if (o == NotificationMsg.BACK) {
                setContentPane(homeScreen.getContent());
            }
        } else if (observable == helpScreen) {
            // TODO
        } else if (observable == playRegScreen) {
            if (o == NotificationMsg.BACK) {
                setContentPane(homeScreen.getContent());
            } else if (o == NotificationMsg.NEW_GAME) {
                if (gameScreen == null || gameFinished) {
                    gameScreen = gameController.getGame().getView();
                    gameScreen.addObserver(this);
                    gameFinished = false;
                }

                JScrollPane scrollPane = new JScrollPane(gameScreen.getContent());
                setContentPane(scrollPane);
            }
        } else if (observable == gameScreen) {
            if (o == NotificationMsg.EXIT_FINISHED) {
                JOptionPane exitNotificationJOP = new JOptionPane(
                        String.format("Game has finished and %s is the winner.\nThe scores are saved in the database!",
                                gameController.getWinnerName()),
                        JOptionPane.INFORMATION_MESSAGE,
                        JOptionPane.DEFAULT_OPTION
                );
                JDialog exitNotificationJOPD = exitNotificationJOP.createDialog("Game has ended!");
                exitNotificationJOPD.setAlwaysOnTop(true);
                exitNotificationJOPD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                exitNotificationJOPD.setVisible(true);
                int JOPSelectedOption = (int) exitNotificationJOP.getValue();
                if (JOPSelectedOption == JOptionPane.YES_OPTION) {
                    setContentPane(homeScreen.getContent());
                    gameFinished = true;
                }
            } else if (o == NotificationMsg.EXIT_NOT_FINISHED) {
                JOptionPane exitQuestionJOP = new JOptionPane(
                        "Are you sure you want to exit?\nProgress and score will not be saved!",
                        JOptionPane.QUESTION_MESSAGE,
                        JOptionPane.YES_NO_OPTION
                );
                JDialog exitQuestionJOPD = exitQuestionJOP.createDialog("Confirmation");
                exitQuestionJOPD.setAlwaysOnTop(true);
                exitQuestionJOPD.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                exitQuestionJOPD.setVisible(true);
                int JOPSelectedOption = (int) exitQuestionJOP.getValue();
                if (JOPSelectedOption == JOptionPane.YES_OPTION) {
                    setContentPane(homeScreen.getContent());
                    gameFinished = true;
                }
            }
        }
        repaint();
        revalidate();
    }


    /**
     * This is an enumeration for the intent intermediation
     */
    enum NotificationMsg {
        PLAY_REG, HIGH_SCORES, HELP, QUIT, NEW_GAME, BACK, EXIT_FINISHED, EXIT_NOT_FINISHED;
    }
}
