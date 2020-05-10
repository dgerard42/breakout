import objectdraw.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Ball extends ActiveObject{

    private GameData gameData;
    private BrickManager brickManager;
    private Paddle paddle;
    private FilledOval ball;

    public Ball(GameData gameData, BrickManager brickManager, Paddle paddle){

        this.gameData = gameData;
        this.brickManager = brickManager;
        this.paddle = paddle;
        ball = new FilledOval((gameData.getCanvasWidth() / 2),
                (gameData.getCanvasHeight() / 2),
                gameData.getBallRadius(),
                gameData.getBallRadius(),
                gameData.getCanvas());
        start();
    }

    public int generateNewXDelta(int current){

        if (current > 0)
            return (ThreadLocalRandom.current().nextInt(gameData.getBallXDeltaMin(), gameData.getBallXDeltaMax()));
        else
            return (-(ThreadLocalRandom.current().nextInt(gameData.getBallXDeltaMin(), gameData.getBallXDeltaMax())));
    }

    public boolean checkBrickCollision(){

        ArrayList<Brick> brickList = brickManager.getBricks();
        for (int currentBrick = 0; currentBrick < brickManager.getActiveBricks(); currentBrick++){
            if (ball.overlaps(brickList.get(currentBrick)))
                System.out.println("YE");
        }
        return false;
    }

    public void run(){

        int deltaX = generateNewXDelta(-1);
        int deltaY = gameData.getBallYDelta();
        while (true){

            if (ball.getX() <= 0 || ball.getX() >= (gameData.getCanvasWidth() - gameData.getBallRadius()))
                deltaX = -deltaX;
            else if (ball.getY() <= 0)
                deltaY = -deltaY;
            else if (ball.overlaps(paddle.getPaddle())) {
                deltaY = -deltaY;
                deltaX = generateNewXDelta(deltaX);
            } else if (checkBrickCollision() == true)
                deltaY = -deltaY;
            ball.move(deltaX, deltaY);
            pause(gameData.getBallSpeed());
        }
    }
}
