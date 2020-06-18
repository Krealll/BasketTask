package com.krealll.day3.validator;

import com.krealll.day3.entity.Basket;

public class BasketValidator {

    public boolean isOkWeight(Basket basket){
        return basket.getCurrentWeight()<=basket.getMaxWeight();
    }

    public  boolean isOkCapacity(Basket basket){
        return basket.getBalls().size()<=basket.getMaxCapacity();
    }

}
