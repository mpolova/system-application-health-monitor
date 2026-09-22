package de.mpolova.healthmonitor;

public class Main {

    public static void main(String[] args) {

        MonitoringConfig config =
                new MonitoringConfig(70, 90);

        SystemMonitor systemMonitor =
                new SystemMonitor();

        ApplicationMonitor applicationMonitor =
                new ApplicationMonitor("https://example.com");

        HealthEvaluator healthEvaluator =
                new HealthEvaluator(config);

        MonitoringService monitoringService =
                new MonitoringService(
                        systemMonitor,
                        applicationMonitor,
                        healthEvaluator
                );

        ConsoleUI consoleUI =
                new ConsoleUI(monitoringService);

        consoleUI.starten();
    }
}