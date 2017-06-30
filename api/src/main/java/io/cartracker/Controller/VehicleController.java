package io.cartracker.Controller;

import io.cartracker.Entity.Reading;
import io.cartracker.Entity.Vehicle;
import io.cartracker.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * Created by MY PC on 6/25/2017.
 */

@RestController
public class VehicleController {


    @Autowired
    VehicleService service;

    @CrossOrigin
    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vin) {
        return service.findOne(vin);
    }

    @CrossOrigin
    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody Vehicle[] Vehicle) {
        for (Vehicle veh : Vehicle) {
            service.create(veh);
            System.out.println(veh.toString());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vin") String vin, @RequestBody Vehicle veh) {
        return service.update(vin, veh);
    }

    @CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
    @RequestMapping(value ="reading/{id}", method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOneReadings(@PathVariable("id") String id) {
        return service.findOneReading(id);
    }

    @CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
    @RequestMapping(value="/reading", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createReadings(@RequestBody List<Reading> re) {
        for (Reading read : re) {
            return service.createReading(read);
        }
        return null;
    }

    @CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
    @RequestMapping(value = "reading/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading updateReadings(@PathVariable("id") String id, @RequestBody Reading re) {
        return service.updateReading(id, re);
    }
}
