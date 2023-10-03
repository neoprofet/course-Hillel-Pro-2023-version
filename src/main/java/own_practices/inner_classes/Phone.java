package own_practices.inner_classes;

public class Phone {


    private String model;
    private String manufacture;
    private final Battery battery;

    public Phone(String model, String manufacture, int batterySize, int batteryCapacity) {
        this.model = model;
        this.manufacture = manufacture;

        battery = new Battery(batterySize, batteryCapacity);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Battery getBattery() {
        return battery;
    }

    // nested static classes
    static class PhoneSoldCounter {
        private static int soldCounter;

        public static void increaseCounter() {
            soldCounter++;
        }

        public static void decreaseCounter() {
            soldCounter--;
        }

        public static int getCounter() {
            return soldCounter;
        }

        public static void setCounter(int count) {
            soldCounter = count;
        }
    }

    // inner non-static classes
    class Battery {
        private int size;
        private int capacityPercents;

        public Battery(int size, int capacityPercents) {
            this.size = size;
            this.capacityPercents = capacityPercents;
        }

        public int getCapacityPercents() {
            return capacityPercents;
        }

        public void setCapacityPercents(int capacityPercents) {
            this.capacityPercents = capacityPercents;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void charge() {
            System.out.println("Phone is charging... Now is " + capacityPercents + "%");
        }
    }

}
