package com.krealll.day3.service;

import com.krealll.day3.entity.Ball;
import com.krealll.day3.entity.Basket;
import com.krealll.day3.entity.Color;

import java.util.List;

public class BasketService {

    public boolean fillBasket (Basket basket,List<Ball> listOfBalls){
        for (Ball ball : listOfBalls) {
            if (!basket.add(ball)) {
                return false;
            }
        }
        return true;
    }

    public int getBallsNumOfColor(Color ballColor, Basket basket) {
        int result=0;
        for(int i=0; i<basket.size();i++){
            if(basket.get(i).getBallColor().equals(ballColor)){
                result++;
            }
        }
        return result;
    }

    public int getBallsNumOfColorStreamAPI(Color ballColor, Basket basket){
        return (int)basket.getBalls().stream().filter(o->o.getBallColor().equals(ballColor)).count();
    }
}
