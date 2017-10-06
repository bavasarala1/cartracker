package io.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "alerts.alertsList", query = "SELECT alerts FROM Alerts alerts "),
        @NamedQuery(name = "alerts.alertsByVin", query = "SELECT alerts FROM Alerts alerts WHERE alerts.carVin = :paramVin "),
        @NamedQuery(name = "alerts.alertsHigh", query = "SELECT alerts FROM Alerts alerts WHERE alerts.priority = 'HIGH' "),
        @NamedQuery(name = "alerts.highByVin", query = "SELECT alerts FROM Alerts alerts WHERE alerts.priority = 'HIGH' AND alerts.carVin = :paramVin")
})
public class Alerts {

    @Id
    private String id;
    private String carVin;
    private String cause;
    private String priority;
    private String timestamp;

    public Alerts(){

    }

    public Alerts(String carVin, String cause, String priority, String Date){
        this.id = UUID.randomUUID().toString();
        this.carVin = carVin;
        this.cause = cause;
        this.priority = priority;
        this.timestamp = Date;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "id='" + id + '\'' +
                ", carVin='" + carVin + '\'' +
                ", cause='" + cause + '\'' +
                ", priority='" + priority + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
