package domain;

import domain.token.Token;
import domain.token.TokenFigure;
import domain.token.TokenType;

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
        this.token = new Token(tokenFigure, TokenType.SIMPLE);
    }

    // METHODS
    public String getName() {
        return name;
    }


}
