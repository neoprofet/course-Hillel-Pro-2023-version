package java_pro_homeworks.pr8.inheritance_demo.group1.entities;

import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Colour;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.InterfaceType;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Material;

public class Mouse extends PheripherialDevice {
    private int dpi;
    private int buttonsCount;

    public Mouse(String manufacturer, String model, String serialNumber, Material[] materials,
                 Colour[] colours, InterfaceType interfaceType, int dpi, int buttonsCount) {
        super(manufacturer, model, serialNumber, materials, colours, interfaceType);
        this.buttonsCount = buttonsCount;
        this.dpi = dpi;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public int getButtonsCount() {
        return buttonsCount;
    }

    public void setButtonsCount(int buttonsCount) {
        this.buttonsCount = buttonsCount;
    }
}
