package java_pro_homeworks.pr8.inheritance_demo.group1.entities;

import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Colour;
import java_pro_homeworks.pr8.inheritance_demo.group1.enums.Material;

public class ComputerDevice {
    private String manufacturer;
    private String model;
    private String serialNumber;
    private Material[] materials;
    private Colour[] colours;

    public ComputerDevice(String manufacturer, String model, String serialNumber,
                          Material[] materials, Colour[] colours) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
        this.materials = materials;
        this.colours = colours;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Material[] getMaterials() {
        return materials;
    }

    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }

    public Colour[] getColours() {
        return colours;
    }

    public void setColours(Colour[] colours) {
        this.colours = colours;
    }
}
