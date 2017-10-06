package io.rest.controller;


import io.rest.Service.VehicleReadingsService;
import io.rest.entity.VehicleReadings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehiclereadings")
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://mocker.egen.io")
public class VehicleReadingsController {

    @Autowired
    VehicleReadingsService vehicleReadingService;

    @RequestMapping(method = RequestMethod.GET,value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleReadings> findAll(){
        return vehicleReadingService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings finByVin(@PathVariable("vin") String vin){
        return vehicleReadingService.findById(vin);
    }

    @RequestMapping(method = RequestMethod.POST,value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleReadings create(@RequestBody VehicleReadings vehicleReadings){
        return vehicleReadingService.create(vehicleReadings);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{vin}")
    public void delete(String vin){
        vehicleReadingService.delete(vin);
    }

}
