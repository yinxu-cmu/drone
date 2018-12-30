package com.challenge.drone.components;

import com.challenge.drone.models.Order;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class OrderParserFactoryTests {

    @Test
    public void testGetParser() {
        OrderParser parser = OrderParserFactory.getParser(Order.class);
        assertThat(parser, instanceOf(DefaultOrderParser.class));
    }

    @Test(expected = RuntimeException.class)
    public void testGetParserNullClass() {
        OrderParserFactory.getParser(null);
    }
}
