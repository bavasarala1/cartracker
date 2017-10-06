package io.rest.controller;

import io.rest.Service.VehicleDetailsService;
import io.rest.entity.VehicleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

//@Controller + @ResponseBody
@RestController
@RequestMapping(value = "/vehicledetails")
@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = "http://mocker.egen.io")
public class VehicleDetailsContoller {

    @Autowired
    VehicleDetailsService vehicleDetailsService;

    @RequestMapping(method = RequestMethod.GET,value="",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VehicleDetails> findAll(){
        return vehicleDetailsService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{vin}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails findByVin(@PathVariable("vin") String vin){
        return vehicleDetailsService.findByVin(vin);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VehicleDetails update(@RequestBody List<VehicleDetails> vehicleDetails){
        return vehicleDetailsService.update(vehicleDetails);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/{vin}")
    public void delete(String vin){
        vehicleDetailsService.delete(vin);
    }
}
