package spaceinvaders.resources.collisiondetectors;

import spaceinvaders.resources.objects.Projectile;

public interface CollisionDetector {
    boolean process(Projectile projectile);
}
