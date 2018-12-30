package com.challenge.drone.components;

import com.challenge.drone.exceptions.InvalidOrderFormatException;
import com.challenge.drone.models.Order;
import com.challenge.drone.models.OrderSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static <T extends Order> List<T> readOrdersFromFile(String fileName, Class<T> orderClass) throws IOException {
        OrderParser parser = OrderParserFactory.getParser(orderClass);
        List<T> list = new ArrayList<>();
        Path path = Paths.get(fileName);
        Stream<String> lines = Files.lines(path);

        lines.forEach((str) -> {
            try {
                T order = orderClass.cast(parser.parseStrToOrder(str));
                list.add(order);
            } catch (InvalidOrderFormatException e) {
                logger.warn(e.getMessage());
                //TODO
            }
        });
        //TODO:  log total num of invalid orders.
        return list;
    }

    public static void writeOrderSchedulesToFile(String fileName, List<OrderSchedule> scheduleList) {

    }


}
