import objectdraw.DrawingCanvas;

public class GameData {

    private int canvasWidth;
    private int canvasHeight;
    private int numBricks;
    private DrawingCanvas canvas;
    private int bricksX;
    private int bricksY;
    private static final int brickWidth = (int)BreakoutProgram.BRICK_WIDTH;
    private static final int brickSep = (int)BreakoutProgram.BRICK_SEP;

    public GameData(){

        canvasWidth = (int)BreakoutProgram.CANVAS_WIDTH;
        canvasHeight = (int)BreakoutProgram.CANVAS_HEIGHT;
        numBricks = BreakoutProgram.NBRICK_COLUMNS * BreakoutProgram.NBRICK_ROWS;
        bricksX = BreakoutProgram.NBRICK_COLUMNS;
        bricksY = BreakoutProgram.NBRICK_ROWS;
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

    public void setCanvas(DrawingCanvas canvas) {
        this.canvas = canvas;
    }

    public DrawingCanvas getCanvas() {
        return canvas;
    }

    public int getBricksX() {
        return bricksX;
    }

    public int getBricksY() {
        return bricksY;
    }

    public static int getBrickWidth() {
        return brickWidth;
    }

    public static int getBrickSep() {
        return brickSep;
    }
}