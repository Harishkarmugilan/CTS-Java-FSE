public class TestSingleton {

    public static void main(String[] args) {

        // Obtain the  Logger instance
        Logger logger1 = Logger.getInstance();

        // Obtain the Logger instance again to prove these both are the same instance
        Logger logger2 = Logger.getInstance();

        // Add log messages using logger1
        logger1.log("Application Started");
        logger1.log("User Logged In");

        // Add log message using logger2
        logger2.log("Payment Successful");

        // Display all logs : will show all three messages since logger1 and logger2 are the same instance
        logger2.showLogs();

        // Verify that both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        }
    }
}