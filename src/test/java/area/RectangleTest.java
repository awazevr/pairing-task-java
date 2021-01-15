package area;


import org.junit.Test;
import static org.junit.Assert.*;


public class RectangleTest {

    @Test
    public void testNullRectangle(){
        Rectangle rect = new Rectangle();
        DataPoint point = new DataPoint(0f, 0f);
        assertFalse(rect.contains(point));
    }

    @Test
    public void testInside(){
        Rectangle rect = new Rectangle(0,0,2,2);
        DataPoint point = new DataPoint(1,1);
        assertTrue(rect.contains(point));
    }

    @Test
    public void testOutside(){
        Rectangle rect = new Rectangle(0,0,2,2);
        DataPoint point = new DataPoint(3,3);
        assertFalse(rect.contains(point));
    }
}
