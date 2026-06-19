public class TestBuilderPattern {

    public static void main(String[] args) {

        // Gaming PC configuration
        Computer gamingPC =
            new ComputerBuilder()
                .setCpu("Intel i7")
                .setRam(16)
                .setStorage(1024)
                .build();

        // Office PC configuration
        Computer officePC =
            new ComputerBuilder()
                .setCpu("Intel i3")
                .setRam(8)
                .setStorage(512)
                .build();

        System.out.println("Gaming PC:");
        gamingPC.showConfiguration();

        System.out.println();

        System.out.println("Office PC:");
        officePC.showConfiguration();
    }
}