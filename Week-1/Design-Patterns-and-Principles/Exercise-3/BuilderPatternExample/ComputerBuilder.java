// Builder Class
public class ComputerBuilder {

    private String cpu;
    private int ram;
    private int storage;

    // Set CPU
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    // Set RAM
    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    // Set Storage
    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    // Build and return Computer object
    public Computer build() {

        Computer computer = new Computer(this);
        return computer;
    }

    // Getters used by Computer constructor
    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }
}