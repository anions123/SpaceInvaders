package spaceinvaders.engine.misc;

import spaceinvaders.resources.collisiondetectors.ProjectileCollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.AlienProjectileCollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.PlayerProjectileCollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.ShieldProjectileCollisionDetector;
import spaceinvaders.resources.collisiondetectors.detectors.UFOProjectileCollisionDetector;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetectorFactory {
    private ArrayList<ProjectileCollisionDetector> collisionList;
    public CollisionDetectorFactory(){
        collisionList = new ArrayList<>();
        addAllCollisionDetectors();
    }

    private void addAllCollisionDetectors(){
        collisionList.add(new AlienProjectileCollisionDetector());
        collisionList.add(new PlayerProjectileCollisionDetector());
        collisionList.add(new ShieldProjectileCollisionDetector());
        collisionList.add(new UFOProjectileCollisionDetector());
    }

    public List<ProjectileCollisionDetector> getCollisionDetectors(){
        return collisionList;
    }
}
