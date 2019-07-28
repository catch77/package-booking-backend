package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.StationPackage;
import com.oocl.packagebooking.service.PackageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class PackageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackageService packageService;

    private StationPackage initPackage() {
        StationPackage stationPackage = new StationPackage();
        stationPackage.setOrderId("123456789");
        stationPackage.setOwnerName("张女士");
        stationPackage.setPhoneNumber("88888888");
        stationPackage.setStatus(0);
        stationPackage.setAppointmentTime("201945555555");
        return stationPackage;
    }

    @Test
    void should_return_All_Packages_when_has_Packages() throws Exception {
        StationPackage stationPackage1 = initPackage();
        StationPackage stationPackage2 = initPackage();

        packageService.AddPackage(stationPackage1);
        packageService.AddPackage(stationPackage2);

        // ResultActions result = mockMvc.perform(delete("/parkinglots/{name}", "FirstParkingLot"));
        ResultActions resultActions = mockMvc.perform(get("/packages"));

        resultActions.andExpect(status().isOk());
    }

}