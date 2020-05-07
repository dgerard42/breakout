import objectdraw.*;

public class GameManager extends WindowController {

    private static GameData gameData;
    private BrickManager brickManager;
    private Ball ball;
    private Paddle paddle;

    public void onMouseMove(Location point){
        paddle.movePaddle(point.getX());
    }

    public void begin(){

        gameData.setCanvas(canvas);
        brickManager = new BrickManager(gameData);
        ball = new Ball(gameData, brickManager);
        paddle = new Paddle(gameData);
    }

    public static void main(String args[]){

        gameData = new GameData();
        new GameManager().startController(gameData.getCanvasWidth(), gameData.getCanvasHeight());
    }
}