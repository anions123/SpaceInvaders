package spaceinvaders.objects;

import spaceinvaders.GameSettings;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;
import spaceinvaders.misc.Shooting;
import spaceinvaders.scenes.BaseLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends GameObject implements Shooting {
    private Projectile projectile;
    private boolean canShoot = true;
    private int livesLeft;
    private int score;

    public Player(Position position) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienBig.png")), position);
        livesLeft = GameSettings.livesLeft;
    }

    public Projectile getProjectile() {
        return projectile;
    }

    @Override
    public boolean canShoot() {

        if(projectile != null && projectile.isAliveProjectile()){
            canShoot = false;
        }
        else{
            canShoot = true;
            if(projectile != null){
                projectile = null;
            }
        }
        return canShoot;
    }

    @Override
    public void shoot(BaseLevel level) throws IOException {
        if(canShoot()){
            projectile = new Projectile(new Position(
                    super.getPosition().getX() + super.getPosition().getCenterOffset_x(),
                    super.getPosition().getY() - super.getSprite().getHeight(),
                    super.getPosition().getDirection_y()), level, "player");
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(super.getSprite(), super.getPosition().getX(), super.getPosition().getY(), null);
        g.drawString("x: "+super.getPosition().getX(), super.getPosition().getX(), super.getPosition().getY()+10);
        g.drawString("y: "+super.getPosition().getY(), super.getPosition().getX(), super.getPosition().getY()+30);
        if(projectile != null && projectile.isAliveProjectile()){
            projectile.render(g);
            g.drawString("x: "+projectile.getPosition().getX(), projectile.getPosition().getX(), projectile.getPosition().getY()+10);
            g.drawString("y: "+projectile.getPosition().getY(), projectile.getPosition().getX(), projectile.getPosition().getY()+30);
        }

    }


    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public void decLivesLeft() {
        this.livesLeft--;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score){
        this.score += score;
    }
}
