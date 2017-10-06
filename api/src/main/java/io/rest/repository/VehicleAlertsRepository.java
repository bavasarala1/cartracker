package io.rest.repository;

import io.rest.entity.Alerts;

import java.util.List;

public interface VehicleAlertsRepository {
    List<Alerts> alertsList();

    List<Alerts> alertByVin(String vin);

    List<Alerts> highAlerts();

    List<Alerts> highByVin(String vin);

    Alerts create(Alerts alerts);
}
