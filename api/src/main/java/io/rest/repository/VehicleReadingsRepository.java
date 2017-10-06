package io.rest.repository;


import io.rest.entity.VehicleReadings;

import java.util.List;

public interface VehicleReadingsRepository {
    public List<VehicleReadings> findAll();
    public VehicleReadings findById(String vin);
    public VehicleReadings create(VehicleReadings vehicleReadings);
    public VehicleReadings update(VehicleReadings vehicleReadings);
    public void delete(VehicleReadings vehicleReadings);
}
