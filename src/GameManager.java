import objectdraw.*;

public class GameManager extends WindowController {

    private static GameSizes gameSizes;
    private Bricks bricks;
    private Ball ball;
    private Paddle paddle;

    public void onMouseMove(Location point){
        paddle.movePaddle(point.getX());
    }

    public void begin(){

        bricks = new Bricks(gameSizes);
        ball = new Ball(gameSizes, bricks);
        paddle = new Paddle(gameSizes);
    }

    public static void main(String args[]){

        gameSizes= new GameSizes();
        new GameManager().startController(gameSizes.getCanvasWidth(), gameSizes.getCanvasHeight());
    }
}