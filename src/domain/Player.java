package domain;

import domain.token.Token;
import domain.token.TokenFigure;

/**
 * Created by
 */
public class Player {

    // ATTRIBUTES
    private String name;
    private Token token;

    // CONSTRUCTOR
    public Player(String name, TokenFigure tokenFigure) {
        this.name = name;
        this.token = new Token();// TODO enum: figure and type
    }

    // METHODS
    public String getName() {
        return name;
    }


}
