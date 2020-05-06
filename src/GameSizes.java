public class GameSizes {

    private int canvasWidth;
    private int canvasHeight;
    private int numBricks;

    public GameSizes(){

        canvasWidth = (int)BreakoutProgram.CANVAS_WIDTH;
        canvasHeight = (int)BreakoutProgram.CANVAS_HEIGHT;
        numBricks = BreakoutProgram.NBRICK_COLUMNS * BreakoutProgram.NBRICK_ROWS;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public int getNumBricks() {
        return numBricks;
    }
}