public class Logger {

    // implemented Private constructor to prevent multiple object creation and maintain a singleton pattern
    private Logger() {}

    // Bill Pugh Singleton implementation
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    private List<String> logs = new ArrayList<>();

    // Global access point to the single Logger instance
    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        logs.add(message);
    }

    public void showLogs() {
        for(String log : logs) {
            System.out.println(log);
        }
    }
}