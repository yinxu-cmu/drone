package com.challenge.drone.components;

import com.challenge.drone.exceptions.InvalidOrderFormatException;
import com.challenge.drone.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DefaultOrderParser extends OrderParser {

    private final static Logger logger = LoggerFactory.getLogger(DefaultOrderParser.class);

    @Override
    public Order parseStrToOrder(String str) throws InvalidOrderFormatException {
        if (str == null || str.isEmpty()) return null;
        str = str.trim();
        String[] args = str.split(" ");
        if (args.length < 3) throw new InvalidOrderFormatException();
        //order id
        if (args[0] == null || args[0].isEmpty()) throw new InvalidOrderFormatException("Empty order id");
        //location
        int dist = parseLocToDist(args[1]);
        //timestamp
        int receiveTime = parseTimestampToSec(args[2]);

        return new Order(args[0], dist, receiveTime);
    }

    private int parseLocToDist(String location) throws InvalidOrderFormatException {
        final Pattern pattern = Pattern.compile("^[NS][\\d]+[WE][\\d]+$");
        Matcher matcher = pattern.matcher(location);
        if (!matcher.matches()) {
            throw new InvalidOrderFormatException("Invalid location string: " + location);
        }
        String[] nums = location.split("[NSWE]");
        return Integer.valueOf(nums[1]) + Integer.valueOf(nums[2]);
    }

    private int parseTimestampToSec(String timestamp) throws InvalidOrderFormatException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setLenient(false);
        Date date, start;

        try {
            date = sdf.parse(timestamp);
            start = sdf.parse("00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new InvalidOrderFormatException("Invalid timestamp string: " + timestamp);
        }

        long diff = date.getTime() - start.getTime();
        return (int) TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
