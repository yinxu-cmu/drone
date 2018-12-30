package com.challenge.drone.components;

import com.challenge.drone.exceptions.InvalidOrderFormatException;
import com.challenge.drone.models.Order;

public abstract class OrderParser {

    /**
     *
     * @param str
     * @return
     * @throws InvalidOrderFormatException
     */
    public abstract Order parseStrToOrder(String str) throws InvalidOrderFormatException;
}
