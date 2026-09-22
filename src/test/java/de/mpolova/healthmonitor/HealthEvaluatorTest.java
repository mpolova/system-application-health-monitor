package de.mpolova.healthmonitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthEvaluatorTest {

    @Test
    void nichtErreichbareAnwendungIstDown() {

        MonitoringConfig config = new MonitoringConfig(70, 90);
        HealthEvaluator evaluator = new HealthEvaluator(config);

        SystemMetrics systemMetrics =
                new SystemMetrics(30, 40, 50);

        ApplicationMetrics applicationMetrics =
                new ApplicationMetrics(false, 0, 0);

        HealthStatus status =
                evaluator.statusBewerten(systemMetrics, applicationMetrics);

        assertEquals(HealthStatus.DOWN, status);
    }

    @Test
    void httpServerfehlerIstCritical() {

        MonitoringConfig config = new MonitoringConfig(70, 90);
        HealthEvaluator evaluator = new HealthEvaluator(config);

        SystemMetrics systemMetrics =
                new SystemMetrics(30, 40, 50);

        ApplicationMetrics applicationMetrics =
                new ApplicationMetrics(true, 500, 200);

        HealthStatus status =
                evaluator.statusBewerten(systemMetrics, applicationMetrics);

        assertEquals(HealthStatus.CRITICAL, status);
    }

    @Test
    void hoheSystemauslastungIstCritical() {
        MonitoringConfig config = new MonitoringConfig(70, 90);
        HealthEvaluator evaluator = new HealthEvaluator(config);

        SystemMetrics systemMetrics =
                new SystemMetrics(95, 40, 50);

        ApplicationMetrics applicationMetrics =
                new ApplicationMetrics(true, 200, 200);

        HealthStatus status =
                evaluator.statusBewerten(systemMetrics, applicationMetrics);

        assertEquals(HealthStatus.CRITICAL, status);
    }

    @Test
    void erhoehteSystemauslastungIstWarning() {
        MonitoringConfig config = new MonitoringConfig(70, 90);
        HealthEvaluator evaluator = new HealthEvaluator(config);

        SystemMetrics systemMetrics =
                new SystemMetrics(30, 75, 50);

        ApplicationMetrics applicationMetrics =
                new ApplicationMetrics(true, 200, 200);

        HealthStatus status =
                evaluator.statusBewerten(systemMetrics, applicationMetrics);

        assertEquals(HealthStatus.WARNING, status);
    }

    @Test
    void normaleMesswerteSindHealthy() {
        MonitoringConfig config = new MonitoringConfig(70, 90);
        HealthEvaluator evaluator = new HealthEvaluator(config);

        SystemMetrics systemMetrics =
                new SystemMetrics(30, 40, 50);

        ApplicationMetrics applicationMetrics =
                new ApplicationMetrics(true, 200, 200);

        HealthStatus status =
                evaluator.statusBewerten(systemMetrics, applicationMetrics);

        assertEquals(HealthStatus.HEALTHY, status);
    }

}