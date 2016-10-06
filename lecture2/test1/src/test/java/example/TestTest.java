package example;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drav on 04.10.2016.
 */
public class TestTest {
    @Test
    public void firstString()
    {
        A obj = new B();
        System.out.println(obj.a);
        System.out.println(obj.db);
    }

    @Test
    public void collection()
    {
        Map<String, Integer> mapping = new HashMap<String, Integer>();

    }
}
