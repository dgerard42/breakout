import objectdraw.*;
import java.lang.System;
import java.awt.Font;

public class Score {

    private int lives;
    private int score;
    private Font font;

    public Score(GameData gameData){

        lives = gameData.getLivesAtStart();
        score = 0;
        font = parseFontString(gameData.getFont());
        Text scoreLabel = new Text("Score:", 20, 20, gameData.getCanvas());
//        System.out.println(scoreLabel.getFont());
        scoreLabel.setFont(font);
//        System.out.println(scoreLabel.getFont());
    }

    public Font parseFontString(String fontString){


        String[] fontComponents = fontString.split("-", 0);
//        int fontType = (fontComponents[1] == "BOLD") ? 1 : 0;
        //DO NOT USE DOUBLE EQUALS TO COMPARE STRINGS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        System.out.println(fontComponents[1]);
        int fontType = 1;
        Font newFont = new Font(fontComponents[0], fontType, Integer.parseInt(fontComponents[2]));
        return newFont;
    }

    public void displayScore(){


    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }
}
