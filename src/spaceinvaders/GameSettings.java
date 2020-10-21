package spaceinvaders;

import java.awt.*;

public class GameSettings {

    private int windowWidth = 1280;
    private int windowHeight = 960;
    private int highScore = 0;
    private int livesLeft = 3;
    private int playerSpeed = 10;
    private int projectileSpeed = 8;
    private int ufoSpeed = 2;
    private Font gameFont;
    private Color backgroundColor = Color.black;
    private Color textColor = Color.green;
    private int gridDelay = 500;
    private int gridDelayDecay = 50;
    private int gameDelay = 8;
    private int gridShootDelay = 1000;
    private int ufoSpawnDelay = 10000;
    private int gridMoveHorizontalSpacing = 16;
    private int gridMoveVerticalSpacing = 64;

    private static GameSettings instance;

    private GameSettings(){}

    public static GameSettings getInstance(){
        if(instance == null){
            instance = new GameSettings();
        }
        return instance;
    }



    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public int getProjectileSpeed() {
        return projectileSpeed;
    }

    public void setProjectileSpeed(int projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
    }

    public Font getGameFont() {
        return gameFont;
    }

    public void setGameFont(Font gameFont) {
        this.gameFont = gameFont;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public int getGridDelay() {
        return gridDelay;
    }

    public void setGridDelay(int gridDelay) {
        this.gridDelay = gridDelay;
    }

    public int getGridDelayDecay() {
        return gridDelayDecay;
    }

    public void setGridDelayDecay(int gridDelayDecay) {
        this.gridDelayDecay = gridDelayDecay;
    }

    public int getGameDelay() {
        return gameDelay;
    }

    public void setGameDelay(int gameDelay) {
        this.gameDelay = gameDelay;
    }


    public int getGridMoveHorizontalSpacing() {
        return gridMoveHorizontalSpacing;
    }

    public void setGridMoveHorizontalSpacing(int gridMoveHorizontalSpacing) {
        this.gridMoveHorizontalSpacing = gridMoveHorizontalSpacing;
    }

    public int getGridMoveVerticalSpacing() {
        return gridMoveVerticalSpacing;
    }

    public void setGridMoveVerticalSpacing(int gridMoveVerticalSpacing) {
        this.gridMoveVerticalSpacing = gridMoveVerticalSpacing;
    }

    public int getUfoSpeed() {
        return ufoSpeed;
    }

    public void setUfoSpeed(int ufoSpeed) {
        this.ufoSpeed = ufoSpeed;
    }

    public int getGridShootDelay() {
        return gridShootDelay;
    }

    public void setGridShootDelay(int gridShootDelay) {
        this.gridShootDelay = gridShootDelay;
    }

    public int getUfoSpawnDelay() {
        return ufoSpawnDelay;
    }

    public void setUfoSpawnDelay(int ufoSpawnDelay) {
        this.ufoSpawnDelay = ufoSpawnDelay;
    }
}