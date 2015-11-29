package domain;

import domain.token.Token;

/**
 * @author anikristo
 */
public class Player {

    // ATTRIBUTES
    private String name;
    private Token token;

    // CONSTRUCTOR
    public Player(String name, String tokenFigure) {
        this.name = name;
//        this.token = new Token(tokenFigure, TokenType.SIMPLE);// TODO enum: figure and type
    }

    // METHODS
    public String getName() {
        return name;
    }

//    public TokenFigure getTokenFigure(){
//        // TODO return token.getFigure();
//    }
//
//    public int getTokenPosition(){
//        // TODO return token.getPosition();
//    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
        // TODO fıx thıs
    }
}
