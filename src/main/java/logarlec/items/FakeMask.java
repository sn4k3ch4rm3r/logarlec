package logarlec.items;

import logarlec.skeleton.Skeleton;

public class FakeMask extends Mask {
    /**
     * A Mask osztály usePassive metódusa
     * Nem csinál semmit
     * @return true
     */
    @Override
    public boolean usePassive() {
        return false;
    }
}
