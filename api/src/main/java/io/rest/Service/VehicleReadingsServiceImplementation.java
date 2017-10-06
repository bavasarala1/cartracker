package io.rest.Service;


import io.rest.entity.Alerts;
import io.rest.entity.VehicleDetails;
import io.rest.entity.VehicleReadings;
import io.rest.exception.ResourceNotFoundException;
import io.rest.repository.VehicleAlertsRepository;
import io.rest.repository.VehicleDetailsRepository;
import io.rest.repository.VehicleReadingsRepository;
import io.rest.rules.EngineCoolantRule;
import io.rest.rules.FuelVolumeRule;
import io.rest.rules.RpmRule;
import io.rest.rules.TirePressureRule;
import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

@Service
public class VehicleReadingsServiceImplementation implements VehicleReadingsService {

    @Autowired
    VehicleAlertsRepository vehicleAlertsRepository;

    @Autowired
    VehicleDetailsRepository vehicleDetailsRepository;

    @Autowired
    VehicleReadingsRepository vehicleReadingsRepository;

    public List<VehicleReadings> findAll() {
            return vehicleReadingsRepository.findAll();
    }

    public VehicleReadings findById(String vin) {
            VehicleReadings existing=vehicleReadingsRepository.findById(vin);
        if(existing==null){
            throw new ResourceNotFoundException("Vehicle with the "+vin+" vin is not found");
        }
        return existing;
    }


    @Transactional
    public VehicleReadings create(final VehicleReadings vehicleReadings) {

//        Optional<VehicleDetails> vehicleDetails = Optional.ofNullable(vehicleDetailsRepository.findByVin(vehicleReadings.getVin()));
//
//        vehicleDetails.ifPresent(car ->{
//            createAlert(vehicleReadings,car);
//        } );

        //return vehicleReadingsRepository.create(vehicleReadings);
            VehicleDetails vehicleDetails=vehicleDetailsRepository.findByVin(vehicleReadings.getVin());
            VehicleReadings exiting=vehicleReadingsRepository.findById(vehicleReadings.getVin());
            if(vehicleDetails!=null){
                createAlert(vehicleReadings,vehicleDetails);
            }
            return vehicleReadingsRepository.create(vehicleReadings);
        }


    public void createAlert(VehicleReadings vehicleReadings, VehicleDetails vehicleDetails){
        if(vehicleReadings.getEngineRpm() > vehicleDetails.getRedLineRpm()){
            Alerts alert = new Alerts(vehicleDetails.getVin(), "EngineRPM", "HIGH", vehicleReadings.getTimestamp());
            vehicleAlertsRepository.create(alert);
        }
        if(vehicleReadings.getFuelVolume() < ((0.1) * vehicleDetails.getMaxFuelVolume() )){
            Alerts alert = new Alerts(vehicleDetails.getVin(), "Fuel Volume Low", "MEDIUM", vehicleReadings.getTimestamp());
            vehicleAlertsRepository.create(alert);
        }
        if(vehicleReadings.getTires().getFrontLeft() < 32 || vehicleReadings.getTires().getFrontLeft() > 36 ||
                vehicleReadings.getTires().getFrontRight() < 32 || vehicleReadings.getTires().getFrontRight() > 36 ||
                vehicleReadings.getTires().getRearLeft() < 32 || vehicleReadings.getTires().getRearLeft() > 36 ||
                vehicleReadings.getTires().getRearRight() < 32 || vehicleReadings.getTires().getRearRight() > 36)
        {

            Alerts alert = new Alerts(vehicleDetails.getVin(), "Tire Pressure", "LOW", vehicleReadings.getTimestamp());
            vehicleAlertsRepository.create(alert);

        }

        if(vehicleReadings.isEngineCoolantLow() == true || vehicleReadings.isCheckEngineLightOn()== true){
            Alerts alert = new Alerts(vehicleDetails.getVin(), "Engine coolant/ Engine Light", "LOW", vehicleReadings.getTimestamp());
            vehicleAlertsRepository.create(alert);
        }
    }
    public void delete(String vin) {
        VehicleReadings existing=vehicleReadingsRepository.findById(vin);
        if(existing==null){
            throw new ResourceNotFoundException("Vehicle with the "+vin+" vin is not found");
        }
        vehicleReadingsRepository.delete(existing);
    }


}
