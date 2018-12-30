package com.challenge.drone.models;

/**
 * Advanced Order class, created for possible future upgrade.
 *
 */
public class AdvOrder extends Order {

    private int weight;

    public AdvOrder() {
    }

    public AdvOrder(String orderId, int distance, int receiveTime, int weight) {
        super(orderId, distance, receiveTime);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {

        return super.toString() +
                "AdvOrder{" +
                "weight=" + weight +
                '}';
    }
}
