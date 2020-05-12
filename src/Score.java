import objectdraw.*;
import java.awt.Font;

public class Score {

    private static final int TEXT_BUFFER_X = 10;
    private static final int TEXT_BUFFER_Y = 30;
    private static final int LABEL_SIZE = 50;
    private static final int LABEL_POSITION_2 = 2;
    private static final int LABEL_POSITION_3 = 3;
    private static final int LABEL_POSITION_4 = 4;
    private static final int FONT_NAME = 0;
    private static final int FONT_TYPE = 1;
    private static final int FONT_SIZE = 2;
    private static final int BOLD = 1;
    private static final int STANDARD = 0;
    private static final int BASIC_SPLIT = 0;

    private GameData gameData;
    private int lives;
    private int score = 0;
    private Font font;
    private Text scoreDisplay;
    private Text livesDisplay;

    public Score(GameData gameData){

        this.gameData = gameData;
        lives = gameData.getLivesAtStart();
        font = parseFontString(gameData.getFont());
        Text scoreLabel = new Text("Score:", TEXT_BUFFER_X, TEXT_BUFFER_Y, gameData.getCanvas());
        Text livesLabel = new Text("Turns:", ((LABEL_SIZE * LABEL_POSITION_2) + (TEXT_BUFFER_X * LABEL_POSITION_2)),
                TEXT_BUFFER_Y, gameData.getCanvas());
        scoreDisplay = new Text(score, (LABEL_SIZE + (TEXT_BUFFER_X * LABEL_POSITION_3)), TEXT_BUFFER_Y,
                gameData.getCanvas());
        livesDisplay = new Text(lives, ((LABEL_SIZE * LABEL_POSITION_3) + (TEXT_BUFFER_X * LABEL_POSITION_4)), TEXT_BUFFER_Y, gameData.getCanvas());
        scoreLabel.setFont(font);
        livesLabel.setFont(font);
        scoreDisplay.setFont(font);
        livesDisplay.setFont(font);
    }

    public Font parseFontString(String fontString){

        String[] fontComponents = fontString.split("-", BASIC_SPLIT);
        int fontType = (fontComponents[FONT_TYPE].equals("BOLD")) ? BOLD : STANDARD;
        Font newFont = new Font(fontComponents[FONT_NAME], fontType, Integer.parseInt(fontComponents[FONT_SIZE]));
        return newFont;
    }

    public void scorePoint(){

        score++;
        scoreDisplay.removeFromCanvas();
        scoreDisplay = new Text(score, (LABEL_SIZE + (TEXT_BUFFER_X * LABEL_POSITION_3)), TEXT_BUFFER_Y,
                gameData.getCanvas());
        scoreDisplay.setFont(font);
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {

        lives--;
        livesDisplay.removeFromCanvas();
        livesDisplay = new Text(lives, ((LABEL_SIZE * LABEL_POSITION_3) + (TEXT_BUFFER_X * LABEL_POSITION_4)), TEXT_BUFFER_Y, gameData.getCanvas());
        livesDisplay.setFont(font);
    }

    public int getScore() {
        return score;
    }

    public boolean endGameVictory() {

        Text victory = new Text("YOU WIN!", (gameData.getCanvasWidth() / 2) - LABEL_SIZE,
                (gameData.getCanvasHeight() / 2), gameData.getCanvas());
        victory.setFont(font);
        return false;
    }
}
