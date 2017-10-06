package io.rest.repository;

import io.rest.entity.Alerts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleAlertsRepositoryImplementation implements VehicleAlertsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Alerts> alertsList() {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.alertsList", Alerts.class);
        List<Alerts> resultList = query.getResultList();
        return resultList;
    }

    public List<Alerts> alertByVin(String vin) {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.alertsByVin", Alerts.class);
        query.setParameter("paramVin", vin);
        List<Alerts> resultList = query.getResultList();

        if(resultList != null && resultList.size() >= 1){
            return resultList;
        }
        else {
            return null;
        }
    }

    public List<Alerts> highAlerts() {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.alertsHigh", Alerts.class);
        List<Alerts> resultList = query.getResultList();

        return resultList;
    }

    public List<Alerts> highByVin(String vin) {
        TypedQuery<Alerts> query = entityManager.createNamedQuery("alerts.highByVin", Alerts.class);
        query.setParameter("paramVin", vin);
        List<Alerts> resultList  = query.getResultList();

        if(resultList != null && resultList.size() >= 1){
            return resultList;
        }
        else {
            return null;
        }
    }

    public Alerts create(Alerts alerts) {
        entityManager.persist(alerts);
        return alerts;
    }
}
