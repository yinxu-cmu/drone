package com.challenge.drone.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliveryServiceImplTests {

    @Autowired
    DeliveryService deliveryService;

    @Test
    public void testSchedule() {
        deliveryService.schedule(null);
    }
}
