import java.util.ArrayList;
import objectdraw.*;
import java.lang.System;

public class BrickManager {

    private GameData gameData;
    private ArrayList<Brick> bricks;
    private int activeBricks;

    public BrickManager(GameData gameData){

        this.gameData = gameData;
        activeBricks = gameData.getNumBricks();
        generateBricks();
    }

    public void generateBricks(){

        int brickID = 0;
        int brickX = (gameData.getCanvasWidth() - ((gameData.getBrickWidth() * gameData.getBricksX()) + (gameData.get))) / 2 ;
        int brickY = 0;
        bricks = new ArrayList<Brick>();
        for (int rowY = 0; rowY < gameData.getBricksY(); rowY++){
            for (int columnX = 0; columnX < gameData.getBricksX(); columnX++){
                bricks.add(new Brick(gameData, brickID, brickX, brickY)); //put real math here!!
                brickID++;
                brickX += 12;
                brickY += 12;
            }
        }
    }

    public void removeBrick(){

    }
}
