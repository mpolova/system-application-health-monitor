package de.mpolova.healthmonitor;

public class ApplicationMetrics {
    private boolean erreichbar;
    private int httpStatuscode;
    private long antwortzeit;

    public ApplicationMetrics (boolean erreichbar,
                               int httpStatuscode,
                               long antwortzeit) {
        this.erreichbar = erreichbar;
        this.httpStatuscode = httpStatuscode;
        this.antwortzeit = antwortzeit;
    }

    public boolean isErreichbar(){
        return erreichbar;
    }

    public int getHttpStatuscode(){
        return httpStatuscode;
    }

    public long getAntwortzeit(){
        return antwortzeit;
    }
}
