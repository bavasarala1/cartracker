package io.rest.Service;


import io.rest.entity.Alerts;
import io.rest.exception.ResourceNotFoundException;
import io.rest.repository.VehicleAlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleAlertsServiceImplementation implements VehicleAlertsService {
    @Autowired
    VehicleAlertsRepository vehicleAlertsRepository;
    public List<Alerts> alertsList() {

        return vehicleAlertsRepository.alertsList();
    }

    public List<Alerts> alertByVin(String vin) {
        List<Alerts> existing=vehicleAlertsRepository.alertByVin(vin);
        if(existing==null){
            throw new ResourceNotFoundException("The car with Vin: " +vin+ " does not exist!");
        }
        return existing;
    }

    public List<Alerts> highAlerts() {
        return vehicleAlertsRepository.highAlerts();
    }

    public List<Alerts> highByVin(String vin) {
        List<Alerts> existing=vehicleAlertsRepository.highByVin(vin);
        if(existing==null){
            throw new ResourceNotFoundException("The car with Vin: " +vin+ " does not exist!");
        }
        return existing;
    }

    public Alerts create(Alerts alerts) {
        return vehicleAlertsRepository.create(alerts);
    }
}
