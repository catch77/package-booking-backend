package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.StationPackage;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public List<StationPackage> findAll() {
        return packageService.findAll();
    }

    @PostMapping
    public List<StationPackage> addPackage(@RequestBody StationPackage p){
        return packageService.AddPackage(p);
    }

    @PutMapping
    public List<StationPackage> update(@RequestBody StationPackage p){
        return packageService.UpdatePackage(p);
    }

    @GetMapping(params = "status")
    public List<StationPackage> sortByStatus(@RequestParam int status){
        return packageService.findAllByStatus(status);
    }

}
