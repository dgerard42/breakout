import objectdraw.*;

public class Ball extends ActiveObject{

    private GameSizes gameSizes;
    private Bricks bricks;

    public Ball(GameSizes gameSizes, Bricks bricks){

        this.gameSizes = gameSizes;
        this.bricks = bricks;
    }
}
