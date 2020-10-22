package spaceinvaders.engine.misc;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.timerlisteners.*;
import spaceinvaders.resources.objects.aliens.UFO;
import spaceinvaders.window.panels.InfoPanel;
import spaceinvaders.resources.objects.Projectile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TimerController {
    private List<Timer> timers;
    private JFrame fMain;
    private InfoPanel pInfo;
    private boolean pause = false;
    private GameSettings gameSettings;

    private static TimerController timerController;



    private TimerController(JFrame fMain, InfoPanel pInfo){
        gameSettings = GameSettings.getInstance();
        timers = new ArrayList<>();
        this.fMain = fMain;
        this.pInfo = pInfo;
        setupBaseTimers();
    }

    public static TimerController getInstance(JFrame fMain, InfoPanel pInfo){
        if(timerController == null){
            timerController = new TimerController(fMain, pInfo);
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
        timers.add(new Timer(gameSettings.getGameDelay(), new GameTimerListener(fMain, pInfo)));
        timers.add(new Timer(gameSettings.getGridDelay(), new GridMovementTimerListener()));
        timers.add(new Timer(gameSettings.getGridShootDelay(), new GridShootingTimerListener()));
        timers.add(new Timer(gameSettings.getUfoSpawnDelay(), new UFOSpawnTimerListener()));
    }

    public void newProjectile(Projectile projectile){
        Timer timer = new Timer(gameSettings.getGameDelay(), new ProjectileTimerListener(projectile));
        timer.start();
        timers.add(timer);
    }

    public void newUFO(UFO ufo){
        Timer timer = new Timer(gameSettings.getGameDelay(), new UFOMovementTimerListener(ufo));
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

    public boolean getPause(){
        return pause;
    }

    public void setPause(boolean state){
        pause = state;
    }


}
