import objectdraw.*;
//import java.lang.System;

public class Paddle extends ActiveObject {

    private GameData gameData;
    private FilledRect paddle;

    public Paddle(GameData gameData){

        this.gameData = gameData;
        paddle = new FilledRect((gameData.getCanvasWidth() / 2),
                (gameData.getCanvasHeight() - gameData.getPaddleYOffset()), gameData.getPaddleWidth(),
                 gameData.getPaddleHeight(), gameData.getCanvas());
        start();
    }

    public void movePaddle(int mouseX){

        double newX = mouseX - (gameData.getPaddleWidth() / 2);
        double newY = gameData.getCanvasHeight() - gameData.getPaddleYOffset();
        if (newX < 0) //check if out of left boundary
            newX = 0;
        else if (newX > (gameData.getCanvasWidth() - gameData.getPaddleWidth())) //check if out of right boundary
            newX = gameData.getCanvasWidth() - gameData.getPaddleWidth();
        paddle.moveTo(newX, newY);
    }

    public FilledRect getPaddle(){
        return paddle;
    }
}
