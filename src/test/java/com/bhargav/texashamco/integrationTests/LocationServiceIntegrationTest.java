package com.bhargav.texashamco.integrationTests;

import com.bhargav.texashamco.dto.LocationDTO;
import com.bhargav.texashamco.service.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceIntegrationTest {

    @Autowired
    LocationService locationService;

    @Test
    public void testGetLocations(){

        List<LocationDTO> locations = locationService.getAllLocations();
        Assert.assertNotNull(locations);
    }
}
