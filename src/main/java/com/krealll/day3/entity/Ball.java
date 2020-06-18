package com.krealll.day3.entity;

public class Ball {

    private Color ballColor;
    private double weight;

    public Ball(Color ballColor, double weight) {
        this.ballColor = ballColor;
        this.weight = weight;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public void setBallColor(Color ballColor) {
        this.ballColor = ballColor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                ballColor == ball.ballColor;
    }

    @Override
    public int hashCode() {
        int result = ballColor!=null? ballColor.hashCode():0;
        long value=Double.doubleToLongBits(weight);
        result=31*result+(int)(value-(value>>>32));
        result=31*result+(int)(value-(value>>>32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Ball:{");
        string.append("Color: ").append(ballColor);
        string.append(", Weight:").append(weight).append("}");
        return string.toString();
    }
}
