package de.mpolova.healthmonitor;

public class MonitoringService {

    private SystemMonitor systemMonitor;
    private ApplicationMonitor applicationMonitor;
    private HealthEvaluator healthEvaluator;

    public MonitoringService(
            SystemMonitor systemMonitor,
            ApplicationMonitor applicationMonitor,
            HealthEvaluator healthEvaluator) {

        this.systemMonitor = systemMonitor;
        this.applicationMonitor = applicationMonitor;
        this.healthEvaluator = healthEvaluator;
    }

    public MonitoringResult monitoringDurchfuehren() {

        SystemMetrics systemMetrics =
                systemMonitor.systemressourcenErfassen();

        ApplicationMetrics applicationMetrics =
                applicationMonitor.anwendungPruefen();

        HealthStatus status = healthEvaluator.statusBewerten(
                systemMetrics,
                applicationMetrics
        );

        return new MonitoringResult(
                systemMetrics,
                applicationMetrics,
                status
        );
    }
}
