import objectdraw.*;

public class Paddle extends ActiveObject {

    private GameSizes gameSizes;
    private FilledRect paddle;

    public Paddle(GameSizes gameSizes){

        this.gameSizes = gameSizes;
        paddle = new FilledRect(30, 30);
        start();
    }

    public movePaddle(int mouseX){

        double newX = 20; //put real math here eventually!!
        double newY = 20;
        paddle.moveTo(newX, newY);
    }
}
