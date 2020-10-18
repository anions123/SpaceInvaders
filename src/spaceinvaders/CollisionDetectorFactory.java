package spaceinvaders;

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
