# Anforderungen

Dieses Dokument beschreibt die Anforderungen an die erste Version des System & Application Health Monitors.

## Funktionale Anforderungen

Die Anwendung soll:

- die aktuelle CPU-Auslastung erfassen
- die Nutzung des Arbeitsspeichers erfassen
- die Festplattennutzung prüfen
- die Erreichbarkeit einer REST-API überprüfen
- den HTTP-Statuscode der Antwort erfassen
- die Antwortzeit der REST-API messen
- die erfassten Werte bewerten
- einen Status wie `HEALTHY`, `WARNING`, `CRITICAL` oder `DOWN` vergeben
- die Ergebnisse in der Konsole ausgeben

## Nichtfunktionale Anforderungen

Die Anwendung soll:

- in Java entwickelt werden
- übersichtlich und modular aufgebaut sein
- einzelne Monitoring-Bereiche voneinander trennen
- Fehler bei der Abfrage einer Anwendung abfangen
- leicht um weitere Monitoring-Funktionen erweiterbar sein

## Abgrenzung der ersten Version

In der ersten Version werden die Monitoring-Ergebnisse nur während der Programmausführung erfasst und in der Konsole ausgegeben.

Eine dauerhafte Speicherung der Daten, eine grafische Benutzeroberfläche und eine REST-Schnittstelle für die Monitoring-Ergebnisse sind für spätere Erweiterungen vorgesehen.
