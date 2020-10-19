package spaceinvaders.engine.misc;

import spaceinvaders.GameSettings;
import spaceinvaders.window.panels.InfoPanel;
import spaceinvaders.resources.objects.Projectile;
import spaceinvaders.resources.timerlisteners.GameTimerListener;
import spaceinvaders.resources.timerlisteners.GridTimerListener;
import spaceinvaders.resources.timerlisteners.ProjectileTimerListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimerController {
    private List<Timer> timers;
    private JFrame f_main;
    private InfoPanel p_info;
    private boolean pause = false;
    private GameSettings gameSettings;

    private static TimerController timerController;


    private TimerController(JFrame f_main, InfoPanel p_info){
        gameSettings = GameSettings.getInstance();
        timers = new ArrayList<>();
        this.f_main = f_main;
        this.p_info = p_info;
        setupBaseTimers();
    }

    public static TimerController getInstance(JFrame f_main, InfoPanel p_info){
        if(timerController == null){
            timerController = new TimerController(f_main, p_info);
        }
        return timerController;
    }

    public static TimerController getInstance(){
        if(timerController == null){
            throw new RuntimeException("Need to add JFrame and InfoPanel first");
        }
        return timerController;
    }

    private void setupBaseTimers(){
        timers.add(new Timer(gameSettings.getGameDelay(), new GameTimerListener(f_main, p_info)));
        timers.add(new Timer(gameSettings.getGridDelay(), new GridTimerListener()));
    }

    public void newProjectile(Projectile projectile){
        Timer timer = new Timer(gameSettings.getProjectileSpeed(), new ProjectileTimerListener(projectile));
        timer.start();
        timers.add(timer);
    }

    public void startAllTimers(){
        for(Timer t : timers){
            t.start();
        }
    }

    public void pauseSwitch(){
        if(pause){
            pause = false;
            startAllTimers();
        }
        else{
            pause = true;
            stopAllTimers();
        }
    }

    public void stopAllTimers(){
        for(Timer t : timers){
            t.stop();
        }
    }

    public void removeExpired(){
        if(!pause){
            Iterator<Timer> iter = timers.iterator();
            while (iter.hasNext()) {
                Timer t = iter.next();
                if (!t.isRunning()) iter.remove();
            }
        }
    }
}
