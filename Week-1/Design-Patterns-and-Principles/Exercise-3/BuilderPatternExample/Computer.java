// Product Class
public class Computer {

    private String cpu;
    private int ram;
    private int storage;

    // Private constructor used by Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    // Display computer configuration
    public void showConfiguration() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Storage: " + storage + " GB");
    }
}