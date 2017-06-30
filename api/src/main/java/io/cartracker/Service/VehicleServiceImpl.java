package io.cartracker.Service;

import io.cartracker.Entity.Reading;
import io.cartracker.Entity.Vehicle;
import io.cartracker.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by MY PC on 6/25/2017.
 */

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository repository;

    public Vehicle create(Vehicle veh) {
        Vehicle existing = repository.findOne(veh.getVin());
        if (existing != null) {

        }
        return repository.create(veh);

    }

    public Vehicle update(String vin, Vehicle veh) {
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {

        }
        return repository.update(veh);
    }

    public Vehicle findOne(String vin) {
            Vehicle existing = repository.findOne(vin);
            if (existing == null) {

            }
            return existing;
    }

    public Reading findOneReading(String id) {
        Reading existing = repository.findOneReading(id);
        if(existing==null){
            //exception
        }
        return existing;
    }

    public Reading createReading(Reading re) {
        if (re != null) {
            Vehicle existing = repository.findOne(re.getId());
            if (existing != null) {

            }
            repository.createReading(re);
        }
        return null;
    }

    public Reading updateReading(String id, Reading re) {
        Reading existing = repository.findOneReading(id);
        if (existing == null) {

        }
        return repository.updateReading(re);
    }

}
