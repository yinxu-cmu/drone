package com.challenge.drone.components;

import com.challenge.drone.models.AdvOrder;
import com.challenge.drone.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderParserFactory {

    private final static Logger logger = LoggerFactory.getLogger(OrderParserFactory.class);

    static OrderParser getParser(Class<?> orderClass) {
        if (orderClass == Order.class) {
            logger.info("Instantiated default order parser");
            return new DefaultOrderParser();
        } else if (orderClass == AdvOrder.class) {
            logger.info("Instantiated advanced order parser");
            return new AdvOrderParser();
        } else {
            logger.error("Unknown order class");
            throw new RuntimeException("Unknown order class in OrderParser factory.");
        }
    }
}
