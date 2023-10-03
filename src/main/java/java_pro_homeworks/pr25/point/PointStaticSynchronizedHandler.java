package java_pro_homeworks.pr25.point;

public class PointStaticSynchronizedHandler {

    /**
     * Monitor required for synchronized block
     */
    public static final Object lock = new Object();

    /**
     * Synchronized static method.
     * method#3 for race condition problem-solving
     */
    public static synchronized void moveStaticSynchronizedMethod(Point point, int dx, int dy) {
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }

    /**
     * Static method with synchronized Block.
     * method#4 for race condition problem-solving
     */
    public static void moveStaticMethodWithSynchronizedBlock(Point point, int dx, int dy) {
        synchronized (lock) {
            point.setX(point.getX() + dx);
            point.setY(point.getY() + dy);
        }
    }
}
