import objectdraw.*;
import java.lang.System;

public class Paddle extends ActiveObject {

    private GameData gameData;
    private FilledRect paddle;

    public Paddle(GameData gameData){

        this.gameData = gameData;
        paddle = new FilledRect(30, 30, 30, 30, gameData.getCanvas());
        //obv put real math here eventually ^^^
        start();
    }

    public void movePaddle(int mouseX){

        double newX = 20; //put real math here eventually!!
        double newY = 20;
        paddle.moveTo(newX, newY);
    }
}
