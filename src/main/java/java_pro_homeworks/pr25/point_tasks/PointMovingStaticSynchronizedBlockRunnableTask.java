package java_pro_homeworks.pr25.point_tasks;

import java_pro_homeworks.pr25.point.Point;
import java_pro_homeworks.pr25.point.PointStaticSynchronizedHandler;

/**
 * Invoking move method of point instance
 * Method is thread-safe (static method with synchronized block)
 * */
public class PointMovingStaticSynchronizedBlockRunnableTask implements Runnable {

    private final Point point;
    private final int dx;
    private final int dy;

    public PointMovingStaticSynchronizedBlockRunnableTask(Point point, int dx, int dy) {
        this.point = point;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void run() {
         PointStaticSynchronizedHandler.moveStaticMethodWithSynchronizedBlock(point,dx,dy);
    }
}
