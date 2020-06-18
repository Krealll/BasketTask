package com.krealll.day3.validator;

import com.krealll.day3.entity.Ball;
import com.krealll.day3.entity.Basket;
import com.krealll.day3.entity.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketValidatorTest {

    BasketValidator basketValidator;

    @BeforeMethod
    public void setUp() {
        basketValidator = new BasketValidator();
    }

    @Test
    public void IsOkWeightPosTest() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(Color.ORANGE,20.0));
        Basket basket = new Basket(ballList,20.0);
        assertTrue(basketValidator.isOkWeight(basket));
    }

    @Test
    public void IsOkWeightNegTest() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(Color.ORANGE,99999.0));
        Basket basket = new Basket(ballList,99999.0);
        assertFalse(basketValidator.isOkWeight(basket));
    }

    @Test
    public void IsOkCapacityPosTest() {
        List<Ball> ballList = new ArrayList<>();
        double weight=0;
        for (int i = 0; i < 19; i++) {
            ballList.add(new Ball(Color.ORANGE,20.0));
            weight+=20.0;
        }
        Basket basket = new Basket(ballList,weight);
        assertTrue(basketValidator.isOkCapacity(basket));
    }

    @Test
    public void testIsOkCapacityNegTest() {
        List<Ball> ballList = new ArrayList<>();
        double weight=0;
        for (int i = 0; i < 22; i++) {
            ballList.add(new Ball(Color.ORANGE,20.0));
            weight+=20.0;
        }
        Basket basket = new Basket(ballList,weight);
        assertFalse(basketValidator.isOkCapacity(basket));
    }
}