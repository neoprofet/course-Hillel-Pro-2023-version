package java_pro_homeworks.pr8.inheritance_demo.group1.entities;

import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Colour;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Material;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Resolution;

public class CurvedMonitor extends Monitor {
    private int curvatureRadius;
    private int curvatureDepth;

    public CurvedMonitor(String manufacturer, String model, String serialNumber,
                         Material[] materials, Colour[] colours, int size,
                         Resolution resolution, int curvatureDepth, int curvatureRadius) {
        super(manufacturer, model, serialNumber, materials, colours, size, resolution);
        this.curvatureDepth = curvatureDepth;
        this.curvatureRadius = curvatureRadius;
    }


    public int getCurvatureRadius() {
        return curvatureRadius;
    }

    public void setCurvatureRadius(int curvatureRadius) {
        this.curvatureRadius = curvatureRadius;
    }

    public int getCurvatureDepth() {
        return curvatureDepth;
    }

    public void setCurvatureDepth(int curvatureDepth) {
        this.curvatureDepth = curvatureDepth;
    }
}
