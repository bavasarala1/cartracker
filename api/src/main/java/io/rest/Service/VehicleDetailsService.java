package io.rest.Service;

import io.rest.entity.VehicleDetails;

import java.util.List;

public interface VehicleDetailsService {
    public List<VehicleDetails> findAll();
    public VehicleDetails findByVin(String vin);
    public VehicleDetails update(List<VehicleDetails> vehicleDetails);
    public void delete(String vin);
}
