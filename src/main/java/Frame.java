/**
 * Created by k2works on 2017/01/16.
 */
public class Frame {
    public int getScore()
    {
        return itsScore;
    }
    public  void add(int pins)
    {
        itsScore += pins;
    }
    private int itsScore = 0;
}
