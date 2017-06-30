package io.cartracker.Repository;

import io.cartracker.Entity.Reading;
import io.cartracker.Entity.Vehicle;

/**
 * Created by MY PC on 6/25/2017.
 */
public interface VehicleRepository {

    Vehicle create(Vehicle vh);

    Vehicle update(Vehicle vh);

    Vehicle findOne(String vin);

    void createReading(Reading re);

    Reading findOneReading(String id);

    Reading updateReading(Reading re);
}
