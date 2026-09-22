package de.mpolova.healthmonitor;

public class ConsoleUI {

    private MonitoringService monitoringService;

    public ConsoleUI(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    public void starten() {

        MonitoringResult ergebnis =
                monitoringService.monitoringDurchfuehren();

        ergebnisseAnzeigen(ergebnis);
    }

    private void ergebnisseAnzeigen(MonitoringResult ergebnis) {

        SystemMetrics systemMetrics = ergebnis.getSystemMetrics();
        ApplicationMetrics applicationMetrics = ergebnis.getApplicationMetrics();

        System.out.println("=== System & Application Health Monitor ===");

        if (Double.isNaN(systemMetrics.getCpuAuslastung())) {
            System.out.println("CPU-Auslastung: nicht verfügbar");
        } else {
            System.out.printf(
                    "CPU-Auslastung: %.2f %%\n",
                    systemMetrics.getCpuAuslastung()
            );
        }

        System.out.printf(
                "Arbeitsspeichernutzung: %.2f %%\n",
                systemMetrics.getArbeitsspeichernutzung()
        );

        System.out.printf(
                "Festplattennutzung: %.2f %%\n",
                systemMetrics.getFestplattennutzung()
        );

        System.out.println(
                "Anwendung erreichbar: " + applicationMetrics.isErreichbar()
        );

        System.out.println(
                "HTTP-Statuscode: " + applicationMetrics.getHttpStatuscode()
        );

        System.out.println(
                "Antwortzeit: " + applicationMetrics.getAntwortzeit() + " ms"
        );

        System.out.println(
                "Health-Status: " + ergebnis.getStatus()
        );
    }
}