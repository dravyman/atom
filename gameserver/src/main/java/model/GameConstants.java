package model;

import java.awt.*;
import java.util.Random;

/**
 * Global static constants
 *
 * @author apomosov
 */

public interface GameConstants {
  int MAX_PLAYERS_IN_SESSION = 10;
  int MAX_SIZE_OF_FIELD = 10000;
  int DEFAULT_WEIGHT_OF_PLAYER = 200;
  int DEFAULT_WEIGHT_OF_FOOD = 100;
  Random rnd = new Random();

  public static Color randomColor()
  {
    return new Color(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
  }

  public static Point randomPoint()
  {
    return new Point(rnd.nextInt(GameConstants.MAX_SIZE_OF_FIELD),rnd.nextInt(GameConstants.MAX_SIZE_OF_FIELD));

  }
}
