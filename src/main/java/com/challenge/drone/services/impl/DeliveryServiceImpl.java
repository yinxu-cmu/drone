package com.challenge.drone.services.impl;

import com.challenge.drone.components.FileUtils;
import com.challenge.drone.configs.AppConfig;
import com.challenge.drone.models.Order;
import com.challenge.drone.models.OrderSchedule;
import com.challenge.drone.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

    private AppConfig appConfig;

    @Autowired
    public DeliveryServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public <T extends Order> List<OrderSchedule> schedule(List<T> list) {
        String s = appConfig.getStartTime();
        System.out.println(s);
//        for (T item : list) {
//            System.out.println(item.getOrderId());
//        }
        return null;
    }
}
