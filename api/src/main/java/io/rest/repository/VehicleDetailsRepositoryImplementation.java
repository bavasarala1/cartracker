package io.rest.repository;

import io.rest.entity.VehicleDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleDetailsRepositoryImplementation implements VehicleDetailsRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<VehicleDetails> findAll() {
        TypedQuery<VehicleDetails> query=entityManager.createNamedQuery("VehicleDetails.findAll",VehicleDetails.class);
        return query.getResultList();
    }

    public VehicleDetails findByVin(String vin) {
            return entityManager.find(VehicleDetails.class,vin);
    }

    public VehicleDetails update(VehicleDetails vehicleDetails) {
        return entityManager.merge(vehicleDetails);
    }

    public VehicleDetails create(VehicleDetails vehicleDetails) {
        entityManager.persist(vehicleDetails);
        return vehicleDetails;
    }

    public void delete(VehicleDetails vehicleDetails) {
        entityManager.remove(vehicleDetails);
    }
}
