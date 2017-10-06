package io.rest.repository;

import io.rest.entity.VehicleDetails;

import java.util.List;

public interface VehicleDetailsRepository {
    public List<VehicleDetails> findAll();
    public VehicleDetails findByVin(String vin);
    public VehicleDetails create(VehicleDetails vehicleDetails);
    public VehicleDetails update(VehicleDetails vehicleDetails);
    public void delete(VehicleDetails vehicleDetails);
}
