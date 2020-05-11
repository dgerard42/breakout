import objectdraw.*;
import java.awt.Color;

public class Brick extends FilledRect {

    private GameData gameData;
    private int brickID;

    public Brick(GameData gamedata, int brickID, int brickX, int brickY, Color color){
        super(brickX, brickY, gamedata.getBrickWidth(), gamedata.getBrickHeight(), gamedata.getCanvas());
        this.brickID = brickID;
        this.gameData = gamedata;
        setColor(color);
    }
}
