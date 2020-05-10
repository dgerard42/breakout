import java.util.ArrayList;
//import objectdraw.*;
//import java.lang.System;
import java.awt.Color;

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
        int brickY = gameData.getBrickYOffset();
        bricks = new ArrayList<Brick>();
        int colorIndex = 0;
        for (int rowY = 0; rowY < gameData.getBricksY(); rowY++){
            int brickX = (gameData.getCanvasWidth() - ((gameData.getBrickWidth() * gameData.getBricksX())
                    + (gameData.getBrickSep() * gameData.getBricksX()))) / 2 ;
            Color currentColor = (gameData.getColors()).get(colorIndex);
            for (int columnX = 0; columnX < gameData.getBricksX(); columnX++){
                bricks.add(new Brick(gameData, brickID, brickX, brickY, currentColor));
                brickID++;
                brickX += gameData.getBrickSep() + gameData.getBrickWidth();
            }
            brickY += gameData.getBrickHeight() + gameData.getBrickSep();
            colorIndex = (rowY % 2 == 0) ? colorIndex : colorIndex + 1; //increment to the next color if you have created 2 rows
        }
    }

    public void removeBrick(){

    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public int getActiveBricks() {
        return activeBricks;
    }
}
