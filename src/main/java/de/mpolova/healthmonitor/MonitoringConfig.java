package de.mpolova.healthmonitor;

public class MonitoringConfig {
    private double warningGrenzwert;
    private double criticalGrenzwert;

    public MonitoringConfig(double warningGrenzwert,
                            double criticalGrenzwert) {
        this.warningGrenzwert = warningGrenzwert;
        this.criticalGrenzwert = criticalGrenzwert;
    }

    public double getWarningGrenzwert() {
        return warningGrenzwert;
    }

    public double getCriticalGrenzwert() {
        return criticalGrenzwert;
    }
}
