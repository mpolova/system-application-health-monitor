package de.mpolova.healthmonitor;

public class HealthEvaluator {

    private MonitoringConfig config;

    public HealthEvaluator(MonitoringConfig config) {
        this.config = config;
    }

    public HealthStatus statusBewerten(
            SystemMetrics systemMetrics,
            ApplicationMetrics applicationMetrics) {

        if (!applicationMetrics.isErreichbar()) {
            return HealthStatus.DOWN;
        }

        if (applicationMetrics.getHttpStatuscode() >= 500) {
            return HealthStatus.CRITICAL;
        }

        if (systemMetrics.getCpuAuslastung() >= config.getCriticalGrenzwert()
                || systemMetrics.getArbeitsspeichernutzung() >= config.getCriticalGrenzwert()
                || systemMetrics.getFestplattennutzung() >= config.getCriticalGrenzwert()) {

            return HealthStatus.CRITICAL;
        }

        if (systemMetrics.getCpuAuslastung() >= config.getWarningGrenzwert()
                || systemMetrics.getArbeitsspeichernutzung() >= config.getWarningGrenzwert()
                || systemMetrics.getFestplattennutzung() >= config.getWarningGrenzwert()) {

            return HealthStatus.WARNING;
        }

        return HealthStatus.HEALTHY;
    }
}