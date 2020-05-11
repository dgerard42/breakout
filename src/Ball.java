import objectdraw.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Ball extends ActiveObject{

    private static final int GENERATE_POSITIVE_RATE = -1;
    private GameData gameData;
    private BrickManager brickManager;
    private Paddle paddle;
    private FilledOval ball;
    private Score score;

    public Ball(GameData gameData, BrickManager brickManager, Paddle paddle){

        this.gameData = gameData;
        this.brickManager = brickManager;
        this.paddle = paddle;
        ball = new FilledOval((gameData.getCanvasWidth() / 2),
                (gameData.getCanvasHeight() / 2),
                gameData.getBallRadius(),
                gameData.getBallRadius(),
                gameData.getCanvas());
        score = new Score(gameData);
        start();
    }

    //generate a random X movement rate within a range, either negative or positive, depending on whether or not the
    //previous X movement rate was positive or negative
    public int generateNewXDelta(int current){

        if (current > 0)
            return (ThreadLocalRandom.current().nextInt(gameData.getBallXDeltaMin(), gameData.getBallXDeltaMax()));
        else
            return (-(ThreadLocalRandom.current().nextInt(gameData.getBallXDeltaMin(), gameData.getBallXDeltaMax())));
    }

    //iterate through all current bricks. If there is a collision, tell the brick manager to remove the brick, and tell
    //the parent ball function if there was a collision or not
    public boolean checkBrickCollision(){

        ArrayList<Brick> brickList = brickManager.getBricks();
        for (int currentBrick = 0; currentBrick < brickManager.getActiveBricks(); currentBrick++){
            if (ball.overlaps(brickList.get(currentBrick))) {
                brickManager.removeBrick(currentBrick);
                score.scorePoint();
                return true;
            }
        }
        return false;
    }

    public boolean loseLife(){

        if (score.getLives() > 1) {
            score.loseLife();
            ball.moveTo((gameData.getCanvasWidth() / 2),(gameData.getCanvasWidth() / 2));
            return true;
        }
        else {
            score.loseLife();
            ball.removeFromCanvas();
            return false;
        }
    }

    //move the ball at generated and assigned rates. check for collisions with if statements and helper functions, and
    //reverse x or y rates of movement if necessary
    public void run(){

        int deltaX = generateNewXDelta(GENERATE_POSITIVE_RATE);
        int deltaY = gameData.getBallYDelta();
        boolean gameActive = true;
        while (gameActive == true) {
            if (ball.getX() <= 0 || ball.getX() >= (gameData.getCanvasWidth() - gameData.getBallRadius()))
                deltaX = -deltaX;
            else if (ball.getY() <= 0)
                deltaY = -deltaY;
            else if (ball.overlaps(paddle.getPaddle())) {
                deltaY = -deltaY;
                deltaX = generateNewXDelta(deltaX);
            } else if (checkBrickCollision() == true)
                deltaY = -deltaY;
            else if (ball.getY() >= (gameData.getCanvasHeight() - gameData.getBallRadius())) {
                gameActive = loseLife();
                deltaX = generateNewXDelta(-deltaX); //generate random inverse direction X movement rate
            } else if (score.getScore() == (gameData.getBricksX() * gameData.getBricksY()))
                gameActive = score.endGameVictory();
            ball.move(deltaX, deltaY);
            pause(gameData.getBallSpeed());
        } if (score.getScore() != (gameData.getBricksX() * gameData.getBricksY())){
            ball.removeFromCanvas();
            (paddle.getPaddle()).removeFromCanvas();
        }
    }
}
