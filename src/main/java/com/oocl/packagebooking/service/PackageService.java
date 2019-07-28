package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.StationPackage;
import com.oocl.packagebooking.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<StationPackage> findAll() {
        return packageRepository.findAll();
    }

    public StationPackage fingByOrderId(String OrderId) {
        return packageRepository.findById(OrderId).get();
    }

    public List<StationPackage> AddPackage(StationPackage p) {
        packageRepository.save(p);
        return packageRepository.findAll();
    }

    //controller是要传入一个id指定包裹，进行更新
    public List<StationPackage> UpdatePackage(StationPackage p) {
        packageRepository.save(p);
        return packageRepository.findAll();
    }

    public List<StationPackage> findAllByStatus(int status) {
        return packageRepository.findAllByStatus(status);
    }


}
