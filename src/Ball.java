import objectdraw.*;

public class Ball extends ActiveObject{

    private GameData gameData;
    private BrickManager brickManager;

    public Ball(GameData gameData, BrickManager brickManager){

        this.gameData = gameData;
        this.brickManager = brickManager;
    }
}
