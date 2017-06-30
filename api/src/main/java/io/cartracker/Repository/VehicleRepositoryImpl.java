package io.cartracker.Repository;

import io.cartracker.Entity.Reading;
import io.cartracker.Entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by MY PC on 6/25/2017.
 */

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Vehicle create(Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }

    public Vehicle update(Vehicle veh) {
        return entityManager.merge(veh);
    }

    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);

    }

    public void createReading(Reading re) {
        entityManager.persist(re);
    }

    public Reading findOneReading(String id) {
        return entityManager.find(Reading.class, id);
    }

    public Reading updateReading(Reading re) {
        return entityManager.merge(re);
    }

}
