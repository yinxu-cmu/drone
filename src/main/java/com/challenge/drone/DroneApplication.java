package com.challenge.drone;

import com.challenge.drone.components.FileUtils;
import com.challenge.drone.configs.AppConfig;
import com.challenge.drone.models.Order;
import com.challenge.drone.models.OrderSchedule;
import com.challenge.drone.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DroneApplication implements CommandLineRunner {

    private AppConfig appConfig;
    private DeliveryService deliveryService;

    @Autowired
    public DroneApplication(AppConfig appConfig, DeliveryService deliveryService) {
        this.appConfig = appConfig;
        this.deliveryService = deliveryService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DroneApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args == null || args.length == 0) return;
        List<Order> orderList = FileUtils.readOrdersFromFile(args[0], Order.class);
        List<OrderSchedule> scheduleList = deliveryService.schedule(orderList);
        FileUtils.writeOrderSchedulesToFile(appConfig.getOutputFile(), scheduleList);
    }
}

