package com.challenge.drone.models;

public class Order {

    private String orderId;
    private int distance; //num of blocks away from the center
    private int receiveTime; //seconds starting from daily operation begin time.

    public Order() {
    }

    public Order(String orderId, int distance, int receiveTime) {
        this.orderId = orderId;
        this.distance = distance;
        this.receiveTime = receiveTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(int receiveTime) {
        this.receiveTime = receiveTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", distance=" + distance +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
