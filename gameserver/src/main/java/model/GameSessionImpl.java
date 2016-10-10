package model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by drav on 10.10.2016.
 */
public class GameSessionImpl implements GameSession{

    private final Map<Player,CirclesBatch> sessionPlayers = new HashMap();
    private final List<Circle> foods = new ArrayList<>();

    @Override
    public void join(@NotNull Player player)
    {
        Circle firstPlayerCircle = new Circle();
        CirclesBatch batch = new CirclesBatch(firstPlayerCircle);
        sessionPlayers.put(player, batch);
    }
}
