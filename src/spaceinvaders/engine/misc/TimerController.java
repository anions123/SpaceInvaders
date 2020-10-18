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
    private static List<Timer> timers;
    private static JFrame f_main;
    private static InfoPanel p_info;
    private static boolean pause = false;
    private static TimerController timerController;

    private TimerController(JFrame f_main, InfoPanel p_info){
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
        timers.add(new Timer(GameSettings.gameDelay, new GameTimerListener(f_main, p_info)));
        timers.add(new Timer(GameSettings.gridDelay, new GridTimerListener()));
    }

    public void newProjectile(Projectile projectile){
        Timer timer = new Timer(GameSettings.projectileSpeed, new ProjectileTimerListener(projectile));
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
