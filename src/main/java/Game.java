/**
 * Created by k2works on 2017/01/30.
 */
public class Game {
    private int itsScore = 0;

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsScore += pins;
    }
}
