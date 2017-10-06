package io.rest.Service;


import io.rest.entity.VehicleReadings;

import java.util.List;

public interface VehicleReadingsService {
    public List<VehicleReadings> findAll();
    public VehicleReadings findById(String vin);
    public VehicleReadings create(VehicleReadings vehicleReadings);
    public void delete(String vin);
}
;