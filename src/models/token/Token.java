package models.token;

/**
 * @author Ali Gocer
 * INV: position >= 0 && position < 40
 * INV: type == TokenType.SIMPLE || type == TokenType.PLATINUM || type == TokenType.GOLDEN
 * INV: figure == TokenFigure.DOG || figure == TokenFigure.CAR || figure == TokenFigure.HAT
 *                      TokenFigure.THIMBLE || figure == TokenFigure.SHOE || figure == TokenFigure.IRON
 */
public class Token {

    // ATTRIBUTES
    private int position;
    private TokenType type;
    private TokenFigure figure;

    // CONSTRUCTOR
    public Token(TokenFigure figure) {
        position = 0;
        type = TokenType.SIMPLE;
        this.figure = figure;
    }


    // METHODS
    public boolean equals(Token o) {
        return figure == o.figure && type == o.type;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public TokenFigure getFigure() {
        return figure;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }
}
