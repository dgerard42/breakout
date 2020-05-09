import objectdraw.DrawingCanvas;
import java.awt.Color;
import java.util.ArrayList;

public class GameData {

    private ArrayList<Color> colors;
    private static final Color COLOR_0 = new Color(88, 39, 7);
    private static final Color COLOR_1 = new Color(151, 45, 7);
    private static final Color COLOR_2 = new Color(255, 75, 62);
    private static final Color COLOR_3 = new Color(255, 178, 15);
    private static final Color COLOR_4 = new Color(255, 229, 72);

    private DrawingCanvas canvas;

    private static final int CANVAS_WIDTH = (int)BreakoutProgram.CANVAS_WIDTH;
    private static final int CANVAS_HEIGHT = (int)BreakoutProgram.CANVAS_HEIGHT;
    private static final int NUM_BRICKS = BreakoutProgram.NBRICK_COLUMNS * BreakoutProgram.NBRICK_ROWS;
    private static final int BRICKS_X = BreakoutProgram.NBRICK_COLUMNS;
    private static final int BRICKS_Y = BreakoutProgram.NBRICK_ROWS;
    private static final int BRICK_WIDTH = (int)BreakoutProgram.BRICK_WIDTH;
    private static final int BRICK_SEP = (int)BreakoutProgram.BRICK_SEP;
    private static final int BRICK_Y_OFFSET = (int)BreakoutProgram.BRICK_Y_OFFSET;
    private static final int BRICK_HEIGHT = (int)BreakoutProgram.BRICK_HEIGHT;

    public GameData(){

        createColorList();
    }

    public void createColorList(){

        colors = new ArrayList<Color>();
        colors.add(COLOR_0);
        colors.add(COLOR_1);
        colors.add(COLOR_2);
        colors.add(COLOR_3);
        colors.add(COLOR_4);
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public int getCanvasWidth() {
        return CANVAS_WIDTH;
    }

    public int getCanvasHeight() {
        return CANVAS_HEIGHT;
    }

    public int getNumBricks() {
        return NUM_BRICKS;
    }

    public void setCanvas(DrawingCanvas canvas) {
        this.canvas = canvas;
    }

    public DrawingCanvas getCanvas() {
        return canvas;
    }

    public int getBricksX() {
        return BRICKS_X;
    }

    public int getBricksY() {
        return BRICKS_Y;
    }

    public static int getBrickWidth() {
        return BRICK_WIDTH;
    }

    public static int getBrickSep() {
        return BRICK_SEP;
    }

    public static int getBrickYOffset() {
        return BRICK_Y_OFFSET;
    }

    public static int getBrickHeight() {
        return BRICK_HEIGHT;
    }
}