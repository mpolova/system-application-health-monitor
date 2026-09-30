# System & Application Health Monitor

Eine Java-Anwendung zur Überwachung von Systemressourcen und der Verfügbarkeit von Anwendungen.

## Projektziel

Das Projekt entsteht im Rahmen meiner Umschulung zur Fachinformatikerin für Anwendungsentwicklung. Ziel ist es, eine kleine Monitoring-Anwendung Schritt für Schritt zu entwickeln und dabei verschiedene Bereiche der Java-Entwicklung praktisch anzuwenden.

## Funktionen

### Version 1

Die erste Version umfasst die grundlegende Überwachung von System und Anwendung:

- Erfassung der CPU-Auslastung
- Erfassung der Arbeitsspeichernutzung
- Erfassung der Festplattennutzung
- Prüfung der Erreichbarkeit einer Anwendung über HTTP
- Erfassung von HTTP-Statuscode und Antwortzeit
- Konfigurierbare Warn- und kritische Grenzwerte
- Bewertung des Zustands als `HEALTHY`, `WARNING`, `CRITICAL` oder `DOWN`
- Behandlung von Netzwerkfehlern und HTTP-Timeouts
- Ausgabe der Monitoring-Ergebnisse in der Konsole

## Statusbewertung

Der Zustand wird anhand der erfassten Messwerte und der definierten Grenzwerte bewertet:

- `HEALTHY` – Systemwerte liegen unterhalb des Warnwerts und die Anwendung ist erreichbar
- `WARNING` – mindestens ein Systemwert erreicht den Warnwert
- `CRITICAL` – mindestens ein Systemwert erreicht den kritischen Grenzwert oder die Anwendung liefert einen HTTP-Statuscode ab 500
- `DOWN` – die Anwendung ist nicht erreichbar

## Technologien

- Java 21
- Maven
- JUnit 5
- Java HTTP Client
- Git & GitHub
- UML

## Tests

Die Bewertungslogik des `HealthEvaluator` wird mit JUnit 5 getestet.

Die Unit-Tests prüfen folgende Szenarien:

- nicht erreichbare Anwendung → `DOWN`
- HTTP-Serverfehler → `CRITICAL`
- kritische Systemauslastung → `CRITICAL`
- erhöhte Systemauslastung → `WARNING`
- normale Messwerte → `HEALTHY`

Die Tests können über den Maven-Lifecycle mit `test` ausgeführt werden.

Aktueller Teststand:

`5 Tests, 0 Failures, 0 Errors`

## Beispielausgabe

```text
=== System & Application Health Monitor ===
CPU-Auslastung: 0,00 %
Arbeitsspeichernutzung: 85,70 %
Festplattennutzung: 41,33 %
Anwendung erreichbar: true
HTTP-Statuscode: 200
Antwortzeit: 767 ms
Health-Status: WARNING
```

Die angezeigten Messwerte hängen vom jeweiligen System und vom Zeitpunkt der Messung ab.

## Dokumentation

Die Anforderungen und UML-Diagramme befinden sich im Ordner `docs`.

Im Rahmen des Projekts wurden folgende UML-Diagramme mit UMLetino erstellt:

- Use-Case-Diagramm
- Aktivitätsdiagramm
- Klassendiagramm

## Geplante Erweiterungen

Für spätere Versionen sind unter anderem folgende Funktionen vorgesehen:

- Speicherung von Monitoring-Daten
- Überwachung mehrerer Anwendungen
- Protokollierung von Statusänderungen
- REST-Schnittstelle für Monitoring-Daten
- einfache grafische Darstellung der Ergebnisse

## Projektstatus

Version 1 ist abgeschlossen.