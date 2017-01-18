/**
 * Created by k2works on 2017/01/18.
 */
public class Game {
    public int score()
    {
        return itsScore;
    }

    public void add(int pins)
    {
        itsScore += pins;
    }
    private int itsScore = 0;
}
