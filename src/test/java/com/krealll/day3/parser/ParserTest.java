package com.krealll.day3.parser;

import com.krealll.day3.exception.ParseException;
import com.krealll.day3.entity.Ball;
import com.krealll.day3.entity.Basket;
import com.krealll.day3.entity.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class ParserTest {

    Parser parser;

    @BeforeMethod
    public void setUp() {
        parser= new Parser();
    }

    @Test
    public void ToBasketValuePosTest() {
        try{
            String testString = "Basket:\nRed 1.32\nBlue 55.88\n";
            Basket expectedBasket = new Basket(new ArrayList<>(),0,20,1000.0),
                    actualBasket;
            expectedBasket.add(new Ball(Color.RED,1.32));
            expectedBasket.add(new Ball(Color.BLUE,55.88));
            actualBasket=parser.toBasketValue(testString);
            assertEquals(actualBasket,expectedBasket);
        }catch (ParseException e){
            fail();
        }
    }

    @Test(expectedExceptions = ParseException.class)
    public void ToBasketValueNegTest() throws ParseException {
        String testString = "Baskeet:\nGreen 1.322\n\nBlack 5.11\n";
        parser.toBasketValue(testString);
    }

    @Test
    public void ToBallValuePosTest() {
        try{
            String testString = "Orange 1.55";
            Ball expectedBall = new Ball(Color.ORANGE, 1.55),
                    actualBall=parser.toBallValue(testString);
            assertEquals(expectedBall,actualBall);
        }catch (ParseException e){
            fail();
        }
    }

    @Test(expectedExceptions = ParseException.class)
    public void ToBallValueNegTest() throws ParseException {
        String testString = "Yellow 1.322a";
        parser.toBallValue(testString);
    }

    @Test
    public void ToColorValuePosTest() {
        try{
            String testString = "Blue";
            Color actualBall=parser.toColorValue(testString);
            assertEquals(Color.BLUE,actualBall);
        }catch (ParseException e){
            fail();
        }
    }

    @Test(expectedExceptions = ParseException.class)
    public void ToColorValueNegTest() throws ParseException {
        String testString = "Brownq";
        parser.toColorValue(testString);
    }
}