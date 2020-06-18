package com.krealll.day3.validator;

import com.krealll.day3.entity.Basket;

public class BasketValidator {

    public boolean isOkWeight(Basket basket){
        return basket.getCurrentWeight()<=Basket.MAX_BALL_CAPACITY;
    }

    public  boolean isOkCapacity(Basket basket){
        return basket.getBalls().size()<=Basket.MAX_BALL_CAPACITY;
    }

}
