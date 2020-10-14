package spaceinvaders;

import spaceinvaders.objects.Projectile;

public interface CollisionDetector {
    boolean process(Projectile projectile);
}
