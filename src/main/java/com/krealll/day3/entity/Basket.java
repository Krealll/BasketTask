package com.krealll.day3.entity;

import java.util.List;

public class Basket {
    public final int maxCapacity;
    public final double maxWeight;
    private List<Ball> balls;
    private double currentWeight;

    public Basket(List<Ball> balls, double currentWeight,int maxBasketCapacity, double maxBasketWeight) {
        this.balls = balls;
        this.currentWeight = currentWeight;
        maxCapacity=maxBasketCapacity;
        maxWeight=maxBasketWeight;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public boolean add(Ball ball) {
        if (ball==null
                ||balls.size()==maxCapacity
                ||(currentWeight+ball.getWeight())>maxWeight)
            return false;
        currentWeight+=ball.getWeight();
        return balls.add(ball);
    }

    public boolean contains(Ball o) {
        return balls.contains(o);
    }

    public int size() {
        return balls.size();
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Double.compare(basket.currentWeight, currentWeight) == 0 &&
                balls!=null?balls.equals(basket.balls):basket.balls==null;
    }

    @Override
    public int hashCode() {
        int result = balls!=null? balls.hashCode():0;
        long value=Double.doubleToLongBits(currentWeight);
        result=31*result+(int)(value-(value>>>32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Basket:{");
        string.append("Current weight: ").append(currentWeight);
        string.append(", Balls:").append(balls).append("}");
        return string.toString();
    }
}
