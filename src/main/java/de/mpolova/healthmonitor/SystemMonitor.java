package de.mpolova.healthmonitor;

import java.io.File;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemMonitor {

    public SystemMetrics systemressourcenErfassen() {
        File festplatte = new File("C:\\");

        long gesamtspeicher = festplatte.getTotalSpace();
        long freierSpeicher = festplatte.getFreeSpace();
        long verwendeterSpeicher = gesamtspeicher - freierSpeicher;

        double festplattennutzung =
                (double) verwendeterSpeicher / gesamtspeicher * 100;

        OperatingSystemMXBean osBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        long gesamterArbeitsspeicher = osBean.getTotalMemorySize();
        long freierArbeitsspeicher = osBean.getFreeMemorySize();

        long verwendeterArbeitsspeicher =
                gesamterArbeitsspeicher - freierArbeitsspeicher;

        double arbeitsspeichernutzung =
                (double) verwendeterArbeitsspeicher / gesamterArbeitsspeicher * 100;

        double cpuAuslastung = osBean.getCpuLoad() * 100;

        return new SystemMetrics(
                cpuAuslastung,
                arbeitsspeichernutzung,
                festplattennutzung
        );
    }
}