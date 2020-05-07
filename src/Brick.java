import objectdraw.*;

public class Brick extends FilledRect {
//u may not need a seperate brick object tbh. might be nice to keep track of hitboxes, but keep in mind
    //that you might want to eliminate this object
    //esp if you don't need hitboxes
    private GameData gameData;
    private int brickID; //brick ID might not be needed, keep an eye on that
    private int hitboxX;
    private int color; //idk if color should be an int but I'll find out later

    public Brick(GameData gamedata, int brickID, int brickX, int brickY){
        super(brickX, brickY, 40, 10, gamedata.getCanvas());
        this.brickID = brickID;
        this.gameData = gamedata;
    }

    public boolean withinBox(){
        return true;
    }
}
