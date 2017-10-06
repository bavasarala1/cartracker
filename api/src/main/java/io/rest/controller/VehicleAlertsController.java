package io.rest.controller;


import io.rest.Service.VehicleAlertsService;
import io.rest.entity.Alerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://mocker.egen.io")
public class VehicleAlertsController {

    @Autowired
    VehicleAlertsService vehicleAlertsService;

    @RequestMapping(method = RequestMethod.GET,value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> alertsList(){
        return vehicleAlertsService.alertsList();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{vin}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> alertByVin(@PathVariable("vin") String vin){
        return vehicleAlertsService.alertByVin(vin);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/highAlerts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> highAlerts(){
        return vehicleAlertsService.highAlerts();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/highAlerts/{vin}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> highByVin(@PathVariable("vin") String vin){
        return vehicleAlertsService.highByVin(vin);
    }

}
