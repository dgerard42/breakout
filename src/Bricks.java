import objectdraw.*;

public class Bricks {

    private GameSizes gameSizes;
//    private ArrayList<> bricks;
    private int activeBricks;

    public Bricks(GameSizes gameSizes){

        this.gameSizes = gameSizes;
        activeBricks = gameSizes.getNumBricks();
        generateBricks();
    }

    public void generateBricks(){

    }

    public void removeBrick(){

    }
}
