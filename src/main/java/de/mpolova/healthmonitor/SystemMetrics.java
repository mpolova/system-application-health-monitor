package de.mpolova.healthmonitor;

public class SystemMetrics {
    private double cpuAuslastung;
    private double arbeitsspeichernutzung;
    private double festplattennutzung;

    public SystemMetrics(double cpuAuslastung,
                         double arbeitsspeichernutzung,
                         double festplattennutzung) {
        this.cpuAuslastung = cpuAuslastung;
        this.arbeitsspeichernutzung = arbeitsspeichernutzung;
        this.festplattennutzung = festplattennutzung;
    }

    public double getCpuAuslastung() {
        return cpuAuslastung;
    }

    public double getArbeitsspeichernutzung() {
        return arbeitsspeichernutzung;
    }

    public double getFestplattennutzung() {
        return festplattennutzung;
    }

}
