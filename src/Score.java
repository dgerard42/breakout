import objectdraw.*;
import java.awt.Font;

public class Score {

    private static final int TEXT_BUFFER_X = 10;
    private static final int TEXT_BUFFER_Y = 30;
    private static final int LABEL_SIZE = 50;

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
        Text livesLabel = new Text("Turns:", ((LABEL_SIZE * 2) + (TEXT_BUFFER_X * 2)), TEXT_BUFFER_Y, gameData.getCanvas());
        scoreDisplay = new Text(score, (LABEL_SIZE + (TEXT_BUFFER_X * 3)), TEXT_BUFFER_Y, gameData.getCanvas());
        livesDisplay = new Text(lives, ((LABEL_SIZE * 3) + (TEXT_BUFFER_X * 4)), TEXT_BUFFER_Y, gameData.getCanvas());
        scoreLabel.setFont(font);
        livesLabel.setFont(font);
        scoreDisplay.setFont(font);
        livesDisplay.setFont(font);
    }

    public Font parseFontString(String fontString){

        String[] fontComponents = fontString.split("-", 0);
        int fontType = (fontComponents[1].equals("BOLD")) ? 1 : 0;
        Font newFont = new Font(fontComponents[0], fontType, Integer.parseInt(fontComponents[2]));
        return newFont;
    }

    public void scorePoint(){

        score++;
        scoreDisplay.removeFromCanvas();
        scoreDisplay = new Text(score, (LABEL_SIZE + (TEXT_BUFFER_X * 3)), TEXT_BUFFER_Y, gameData.getCanvas());
        scoreDisplay.setFont(font);
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {

        lives--;
        livesDisplay.removeFromCanvas();
        livesDisplay = new Text(lives, ((LABEL_SIZE * 3) + (TEXT_BUFFER_X * 4)), TEXT_BUFFER_Y, gameData.getCanvas());
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
