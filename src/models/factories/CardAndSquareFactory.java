package models.factories;

import java.util.List;

/**
 * @author Alper Önder
 */
public interface CardAndSquareFactory {
    <T> List<T> getSquares();
}
