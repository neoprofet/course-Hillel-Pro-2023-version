package java_pro_homeworks.pr25.point_tasks;

import java_pro_homeworks.pr25.point.Point;

/**
 * Invoking move method of point instance
 * Method is non-thread-safe (non-synchronized)
 * */
public class PointMovingNonThreadSafeRunnableTask implements Runnable {

    private final Point point;
    private final int dx;
    private final int dy;

    public PointMovingNonThreadSafeRunnableTask(Point point, int dx, int dy) {
        this.point = point;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void run() {
        point.move(dx, dy);
    }
}
