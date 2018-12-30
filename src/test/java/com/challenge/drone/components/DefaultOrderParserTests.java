package com.challenge.drone.components;

import com.challenge.drone.exceptions.InvalidOrderFormatException;
import com.challenge.drone.models.Order;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DefaultOrderParserTests {

    private OrderParser parser;

    @Before
    public void init() {
        parser = OrderParserFactory.getParser(Order.class);
    }

    @Test(expected = InvalidOrderFormatException.class)
    public void testParseStrToOrderInvalidLoc1() throws InvalidOrderFormatException {
        String str = "WM001 N11W5N11  05:11:50";
        parser.parseStrToOrder(str);
    }

    @Test(expected = InvalidOrderFormatException.class)
    public void testParseStrToOrderInvalidLoc2() throws InvalidOrderFormatException {
        String str = "WM001 A11W5 05:11:50";
        parser.parseStrToOrder(str);
    }

    @Test(expected = InvalidOrderFormatException.class)
    public void testParseStrToOrderInvalidLoc3() throws InvalidOrderFormatException {
        String str = "WM001 N1.1W5 05:11:50";
        parser.parseStrToOrder(str);
    }

    @Test(expected = InvalidOrderFormatException.class)
    public void testParseStrToOrderInvalidLoc4() throws InvalidOrderFormatException {
        String str = "WM001 N11W5 25:11:50";
        parser.parseStrToOrder(str);
    }

    @Test
    public void testParseStrToOrder() throws InvalidOrderFormatException {
        String str = "WM001 S11W5 05:11:50";
        Order order = parser.parseStrToOrder(str);
        assertThat(order, notNullValue());
        assertThat(order.getOrderId(), equalTo("WM001"));
        assertThat(order.getDistance(), is(16));
        assertThat(order.getReceiveTime(), is(18710));
    }


}
