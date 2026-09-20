package de.mpolova.healthmonitor;

public class MonitoringResult {
    private SystemMetrics systemMetrics;
    private ApplicationMetrics applicationMetrics;
    private HealthStatus status;

    public MonitoringResult(SystemMetrics systemMetrics,
                            ApplicationMetrics applicationMetrics,
                            HealthStatus status) {
        this.systemMetrics = systemMetrics;
        this.applicationMetrics = applicationMetrics;
        this.status = status;
    }

    public SystemMetrics getSystemMetrics() {
        return systemMetrics;
    }

    public ApplicationMetrics getApplicationMetrics() {
        return applicationMetrics;
    }

    public HealthStatus getStatus() {
        return status;
    }
}
