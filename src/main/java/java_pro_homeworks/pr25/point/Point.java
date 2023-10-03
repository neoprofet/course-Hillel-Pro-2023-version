package java_pro_homeworks.pr25.point;

public class Point {
    private int x;
    private int y;

    /**
     * Monitor required for synchronized block
     */
    private static final Object lock = new Object();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Synchronized non-static method.
     * method#1 for race condition problem-solving
     */
    public synchronized void moveSynchronizedMethod(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Method with synchronized Block.
     * method#2 for race condition problem-solving
     */
    public void moveMethodWithSynchronizedBlock(int dx, int dy) {
        synchronized (lock) {
            x += dx;
            y += dy;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
