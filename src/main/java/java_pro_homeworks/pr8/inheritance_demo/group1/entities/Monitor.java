package java_pro_homeworks.pr8.inheritance_demo.group1.entities;

import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Colour;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Material;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Resolution;

public class Monitor extends ComputerDevice{
    private int size;
    private Resolution resolution;

    public Monitor(String manufacturer, String model, String serialNumber,
                   Material[] materials, Colour[] colours,
                   int size, Resolution resolution) {
        super(manufacturer, model, serialNumber, materials, colours);
        this.size = size;
        this.resolution = resolution;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }
}
