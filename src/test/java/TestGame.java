import junit.framework.TestCase;

/**
 * Created by k2works on 2017/01/18.
 */
public class TestGame extends TestCase {
    public TestGame(String name)
    {
        super(name);
    }
    public void testOneThrow()
    {
        Game g = new Game();
        g.add(5);
        assertEquals(5, g.score());
    }
}