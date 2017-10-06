package io.rest.repository;

import io.rest.entity.VehicleReadings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class VehicleReadingsRepositoryImplementation implements VehicleReadingsRepository {


    @PersistenceContext
    private EntityManager entityManager;
    public List<VehicleReadings> findAll() {
//        VehicleReadings vehicleReadings = new VehicleReadings();
//        vehicleReadings.setVin("1HGCR2F3XFA027534");
//        vehicleReadings.setLatitude(41.803194);
//        vehicleReadings.setLongitude(-88.144406);
//        vehicleReadings.setTimestamp("2017-05-25T17:31:25.268Z");
//        vehicleReadings.setFuelVolume(1.5);
//        vehicleReadings.setSpeed(85);
//        vehicleReadings.setEngineHp(240);
//        vehicleReadings.setCheckEngineLightOn(false);
//        vehicleReadings.setEngineCoolantLow(true);
//        vehicleReadings.setCruiseControlOn(true);
//        vehicleReadings.setEngineRpm(6300);
//
//        Tires tires = new Tires();
//        tires.setId(1);
//        tires.setFrontLeft(34);
//        tires.setFrontRight(36);
//        tires.setRearLeft(29);
//        tires.setRearRight(34);
//        vehicleReadings.setTires(tires);
//
//        VehicleReadings vehicleReadings2 = new VehicleReadings();
//        vehicleReadings2.setVin("1HGCR2F3XFA0274");
//        vehicleReadings2.setLatitude(41.803194);
//        vehicleReadings2.setLongitude(-88.144406);
//        vehicleReadings2.setTimestamp("2017-05-25T17:31:25.268Z");
//        vehicleReadings2.setFuelVolume(1.5);
//        vehicleReadings2.setSpeed(85);
//        vehicleReadings2.setEngineHp(240);
//        vehicleReadings2.setCheckEngineLightOn(false);
//        vehicleReadings2.setEngineCoolantLow(true);
//        vehicleReadings2.setCruiseControlOn(true);
//        vehicleReadings2.setEngineRpm(6300);
//
//
//        Tires tires2 = new Tires();
//        tires2.setId(2);
//        tires2.setFrontLeft(34);
//        tires2.setFrontRight(36);
//        tires2.setRearLeft(29);
//        tires2.setRearRight(34);
//
//        vehicleReadings.setTires(tires2);

        TypedQuery<VehicleReadings> query=entityManager.createNamedQuery("VehicleReadings.findAll",VehicleReadings.class);
        return query.getResultList();
    }

    public VehicleReadings findById(String vin) {
        return entityManager.find(VehicleReadings.class,vin);
    }

    public VehicleReadings create(VehicleReadings vehicleReadings) {
        entityManager.persist(vehicleReadings);
        return vehicleReadings;
    }

    public VehicleReadings update(VehicleReadings vehicleReadings) {
        return entityManager.merge(vehicleReadings);
    }

    public void delete(VehicleReadings vehicleReadings) {
        entityManager.remove(vehicleReadings);
    }
}
