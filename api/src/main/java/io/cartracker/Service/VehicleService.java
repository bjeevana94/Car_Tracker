package io.cartracker.Service;

import io.cartracker.Entity.Reading;
import io.cartracker.Entity.Vehicle;

/**
 * Created by MY PC on 6/25/2017.
 */
public interface VehicleService {

    Vehicle create(Vehicle veh);

    Vehicle update(String vin, Vehicle veh);

    Vehicle findOne(String vin);

    Reading findOneReading(String id);

    Reading createReading(Reading re);

    Reading updateReading(String id, Reading re);

}
