package java_pro_homeworks.pr8.inheritance_demo.group1.entities;

import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Colour;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.InterfaceType;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Material;

public class Printer extends PheripherialDevice {
    private int printSpeed; //ms
    private int paperSize; //mm

    public Printer(String manufacturer, String model, String serialNumber,
                   Material[] materials, Colour[] colours,
                   InterfaceType interfaceType, int paperSize, int printSpeed) {
        super(manufacturer, model, serialNumber, materials, colours, interfaceType);

    }

    public int getPrintSpeed() {
        return printSpeed;
    }

    public void setPrintSpeed(int printSpeed) {
        this.printSpeed = printSpeed;
    }

    public int getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(int paperSize) {
        this.paperSize = paperSize;
    }
}
