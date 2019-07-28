package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.StationPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<StationPackage, String> {
    List<StationPackage> findAllByStatus(int status);

}
