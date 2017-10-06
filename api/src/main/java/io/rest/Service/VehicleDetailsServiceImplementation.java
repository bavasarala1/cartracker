package io.rest.Service;

import io.rest.entity.VehicleDetails;
import io.rest.exception.ResourceNotFoundException;
import io.rest.repository.VehicleDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class VehicleDetailsServiceImplementation implements VehicleDetailsService {
   @Autowired
   VehicleDetailsRepository vehicleDetailsRepository;

    public List<VehicleDetails> findAll() {
        return vehicleDetailsRepository.findAll();
    }

    public VehicleDetails findByVin(String vin) {
        VehicleDetails existing=vehicleDetailsRepository.findByVin(vin);
        if(existing==null){
            throw new ResourceNotFoundException("Vehicle with the "+vin+" vin is not found");
        }
        return existing;
    }

    @Transactional
    public VehicleDetails update(List<VehicleDetails> vehicleDetails) {

        for(VehicleDetails vehicle: vehicleDetails) {
            VehicleDetails existing = vehicleDetailsRepository.findByVin(vehicle.getVin());
            if (existing == null) {
                return vehicleDetailsRepository.create(vehicle);
            }
            return vehicleDetailsRepository.update(vehicle);
        }
        return null;
    }

    @Transactional
    public void delete(String vin) {
        VehicleDetails existing=vehicleDetailsRepository.findByVin(vin);
        if(existing==null){
            throw new ResourceNotFoundException("Vehicle with the "+vin+" vin is not found");
        }
        vehicleDetailsRepository.delete(existing);
    }
}
