package com.challenge.drone.services;

import com.challenge.drone.models.Order;
import com.challenge.drone.models.OrderSchedule;

import java.util.List;

public interface DeliveryService {

    <T extends Order> List<OrderSchedule> schedule(List<T> list);
}
