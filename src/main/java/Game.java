import java.util.Map;

/**
 * Created by k2works on 2017/01/30.
 */
public class Game {
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;
    private int ball;

    public int score() {
        return scoreForFrame(getCurrentFrame()-1);
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame == true) {
            if( pins == 10 ) // ストライク
                itsCurrentFrame++;
            else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int scoreForFrame(int theFrame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0;
                currentFrame < theFrame;
                currentFrame++)
        {
            if (strike()) {
                ball++;
                score += 10 + itsThrows[ball] + itsThrows[ball+1];
            }
            else {
                score += handleSecondThrow();
            }
        }
        return score;
    }

    private boolean strike() {
        return itsThrows[ball] == 10;
    }

    private int handleSecondThrow() {
        int score = 0;
        // スペアの得点計算には次のフレームの第１投が必要
        if (spare()) {
            ball += 2;
            score += 10 + nextBall();
        }
        else {
            score += twoBallsInFrame();
            ball += 2;
        }
        return score;
    }

    private boolean spare() {
        return (itsThrows[ball] + itsThrows[ball+1]) == 10;
    }

    private int nextBall() {
        return itsThrows[ball];
    }

    private int twoBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball+1];
    }
}
