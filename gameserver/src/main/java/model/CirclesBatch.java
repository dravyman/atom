package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drav on 10.10.2016.
 */
public class CirclesBatch
{
    private final List<Circle> allCircles = new ArrayList<>();

    public List<Circle> getAllCircles()
    {
        return allCircles;
    }

    public int getCommonWeight()
    {
        int sum = 0;
        for (Circle cr : allCircles) {
            sum += cr.getWeight();
        }
        return sum;
    }

    public CirclesBatch(Circle cr)
    {
        this.allCircles.add(cr);
    }
}
