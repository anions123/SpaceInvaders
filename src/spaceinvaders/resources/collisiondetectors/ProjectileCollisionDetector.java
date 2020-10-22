package spaceinvaders.resources.collisiondetectors;

import spaceinvaders.resources.objects.Projectile;

public interface ProjectileCollisionDetector {
    boolean process(Projectile projectile);
}
