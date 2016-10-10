package model;

import javax.xml.stream.Location;
import java.awt.*;
import java.util.Random;

/**
 * Created by drav on 10.10.2016.
 */
public class Circle
{

    static Random rnd = new Random();
    private Point loc;
    private int weight;
    private Color clr;

    public Point getLoc()
    {
        return loc;
    }

    public int getWeight()
    {
        return weight;
    }
    public Circle(Player player)
    {
        this.weight = GameConstants.DEFAULT_WEIGHT_OF_PLAYER;
        this.loc = GameConstants.randomPoint();
        this.clr = GameConstants.randomColor();
    }
    public Circle()
    {
        this.weight = GameConstants.DEFAULT_WEIGHT_OF_FOOD;
        this.loc = GameConstants.randomPoint();
        this.clr = GameConstants.randomColor();
    }
}
