package java_pro_homeworks.pr8.inheritance_demo.group1.entities;

import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Colour;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.InterfaceType;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Material;

public class PheripherialDevice extends ComputerDevice {
    private InterfaceType interfaceType;

    public PheripherialDevice(String manufacturer, String model, String serialNumber,
                              Material[] materials, Colour[] colours, InterfaceType interfaceType) {
        super(manufacturer, model, serialNumber, materials, colours);
        this.interfaceType = interfaceType;
    }

    public InterfaceType getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(InterfaceType interfaceType) {
        this.interfaceType = interfaceType;
    }
}
