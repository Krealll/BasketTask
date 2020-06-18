package com.krealll.day3.service;

import com.krealll.day3.entity.Ball;
import com.krealll.day3.entity.Basket;
import com.krealll.day3.entity.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class BasketServiceTest {

    BasketService basketService;

    @BeforeMethod
    public void setUp() {
        basketService = new BasketService();
    }

    @Test
    public void FillBasketPosTest() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(Color.ORANGE,1.66));
        ballList.add(new Ball(Color.RED,16.002));
        ballList.add(new Ball(Color.GREEN,177.43));
        ballList.add(new Ball(Color.BLUE,111.56));
        Basket actualBasket = new Basket(new ArrayList<>(),0);
        assertTrue(basketService.fillBasket(actualBasket,ballList));
    }

    @Test
    public void FillBasketNegTest() {
        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(Color.ORANGE,1000.0));
        ballList.add(new Ball(Color.RED,16.002));
        ballList.add(new Ball(Color.GREEN,177.43));
        ballList.add(new Ball(Color.BLUE,111.56));
        Basket actualBasket = new Basket(new ArrayList<>(),0);
        assertFalse(basketService.fillBasket(actualBasket,ballList));
    }

    @Test
    public void GetBallsNumOfColorPosTest() {
        Basket basket = new Basket(new ArrayList<>(),0);
        basket.add(new Ball(Color.RED,10.0));
        basket.add(new Ball(Color.RED,20.0));
        basket.add(new Ball(Color.BLUE,13.0));
        basket.add(new Ball(Color.RED,17.0));
        assertEquals(basketService.getBallsNumOfColor(Color.RED,basket),3);
    }

    @Test
    public void GetBallsNumOfColorStreamAPIPosTest() {
        Basket basket = new Basket(new ArrayList<>(),0);
        basket.add(new Ball(Color.RED,10.0));
        basket.add(new Ball(Color.RED,20.0));
        basket.add(new Ball(Color.BLUE,13.0));
        basket.add(new Ball(Color.BLUE,17.0));
        assertEquals(basketService.getBallsNumOfColorStreamAPI(Color.BLUE,basket),2);
    }
}