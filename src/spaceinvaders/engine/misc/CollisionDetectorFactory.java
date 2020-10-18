package spaceinvaders.engine.misc;

import spaceinvaders.resources.collisiondetectors.CollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.AlienCollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.PlayerCollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.ShieldCollisionDetector;

import java.util.ArrayList;

public class CollisionDetectorFactory {
    private ArrayList<CollisionDetector> collisionList;
    public CollisionDetectorFactory(){
        collisionList = new ArrayList<>();
        addAllCollisionDetectors();
    }

    private void addAllCollisionDetectors(){
        collisionList.add(new AlienCollisionDetector());
        collisionList.add(new PlayerCollisionDetector());
        collisionList.add(new ShieldCollisionDetector());
    }

    public ArrayList<CollisionDetector> getCollisionDetectors(){
        return collisionList;
    }
}
